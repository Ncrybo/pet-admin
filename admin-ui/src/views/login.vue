<template>
  <div class="login">
    <el-row>
      <!-- <el-col :span="1"></el-col> -->
      <el-col :span="9" :offset="14">
        <transition name="animate__animated animate__bounce" enter-active-class="animate__fadeInDown" :appear="true">
        <el-form ref="loginForm" :model="loginForm" :rules="loginRules" class="loginForm">
          <h1 class="title">hello !</h1>
          <div class="title-tips">欢迎来到 Admin 控制台</div>
          <el-form-item prop="username">
            <el-input v-model="loginForm.username" placeholder="请输入账号">
              <i
                slot="prefix"
                class="el-input__icon el-icon-user-solid"
              />
            </el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input 
            v-model="loginForm.password"
            type="password"
            auto-complete="off"
            placeholder="密码"
            @keyup.enter.native="handleLogin"
            >
              <i
                slot="prefix"
                icon-class="user"
                class="el-input__icon el-icon-lock"
              />
            </el-input>
          </el-form-item>
          
          <el-form-item prop="code" v-if="captchaEnabled">
            <el-input
              v-model="loginForm.code"
              auto-complete="off"
              placeholder="验证码"
              style="width: 53%"
              @keyup.enter.native="handleLogin"
            >
              <svg-icon slot="prefix" icon-class="validCode" class="el-input__icon input-icon" />
            </el-input>
            <div class="login-code">
              <img :src="codeUrl" @click="getCode" class="login-code-img"/>
            </div>
          </el-form-item>

          <el-form-item>
            <el-button 
            :loading="loading" 
            type="primary" 
            @click.native.prevent="handleLogin"
            class="submit-btn">
            <span v-if="!loading">登 录</span>
            <span v-else>登 录 中...</span>
            </el-button>
          </el-form-item>
          <template>
            <router-link to="/register" class="regest">注册</router-link>
          </template>
        </el-form>
        </transition>
        
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { getCodeImg } from "@/api/login";
import Cookies from "js-cookie";
import { encrypt, decrypt } from '@/utils/jsencrypt'

export default {
  name: "Login",
  data() {
    return {
      codeUrl: "",
      loginForm: {
        username: "admin",
        password: "admin123",
        rememberMe: false,
        code: "",
        uuid: ""
      },
      loginRules: {
        username: [
          { required: true, trigger: "blur", message: "请输入您的账号" }
        ],
        password: [
          { required: true, trigger: "blur", message: "请输入您的密码" }
        ],
        code: [{ required: true, trigger: "change", message: "请输入验证码" }]
      },
      loading: false,
      // 验证码开关
      captchaEnabled: true,
      // 注册开关
      register: false,
      redirect: undefined
    };
  },
  watch: {
    $route: {
      handler: function(route) {
        this.redirect = route.query && route.query.redirect;
      },
      immediate: true
    }
  },
  created() {
    this.getCode();
    this.getCookie();
  },
  methods: {
    getCode() {
      getCodeImg().then(res => {
        this.captchaEnabled = res.captchaEnabled === undefined ? true : res.captchaEnabled;
        if (this.captchaEnabled) {
          this.codeUrl = "data:image/gif;base64," + res.img;
          this.loginForm.uuid = res.uuid;
        }
      });
    },
    getCookie() {
      const username = Cookies.get("username");
      const password = Cookies.get("password");
      const rememberMe = Cookies.get('rememberMe')
      this.loginForm = {
        username: username === undefined ? this.loginForm.username : username,
        password: password === undefined ? this.loginForm.password : decrypt(password),
        rememberMe: rememberMe === undefined ? false : Boolean(rememberMe)
      };
    },
    handleLogin() {
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          this.loading = true;
          if (this.loginForm.rememberMe) {
            Cookies.set("username", this.loginForm.username, { expires: 30 });
            Cookies.set("password", encrypt(this.loginForm.password), { expires: 30 });
            Cookies.set('rememberMe', this.loginForm.rememberMe, { expires: 30 });
          } else {
            Cookies.remove("username");
            Cookies.remove("password");
            Cookies.remove('rememberMe');
          }
          this.$store.dispatch("Login", this.loginForm).then(() => {
            this.$router.push({ path: this.redirect || "/" }).catch(()=>{});
          }).catch(() => {
            this.loading = false;
            if (this.captchaEnabled) {
              this.getCode();
            }
          });
        }
      });
    }
  }
};
</script>

<style lang="scss" scoped>
.login {
  display: block;
  height: 100vh;
  width: 100vw;
  background-image: url("../assets/images/login-background.jpg");
  background-size: cover;
}
.loginForm {
  padding: 4.5vh;
  margin: calc(50vh - 237.5px) 5vw 5vw;
  overflow: hidden;
  background-image: url("../assets/images/login-form-background.png");
  background-size: 100% 100%;
}
.title {
  color: #fff;
  font-size: 54px;
  font-weight: 500;
  margin: 0 10px 20px 0;
}
.loginForm > .title-tips {
    margin: 29px 0;
    font-size: 26px;
    font-weight: 400;
    color: #fff;
}
.submit-btn {
  width: 60%;
}
.regest {
  margin-top: 10px;
}
a {
  text-decoration: none;
  color: #1890ff;
}
.login-code {
  width: 33%;
  height: 38px;
  float: right;
  img {
    cursor: pointer;
    vertical-align: middle;
  }
}
.login-code-img {
  height: 38px;
}
</style>