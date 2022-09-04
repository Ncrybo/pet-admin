<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="店铺名" prop="shopName">
        <el-input
          v-model="queryParams.shopName"
          placeholder="请输入店铺名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺头像" prop="shopImg">
        <el-input
          v-model="queryParams.shopImg"
          placeholder="请输入店铺头像"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺评分" prop="shopStar">
        <el-input
          v-model="queryParams.shopStar"
          placeholder="请输入店铺评分"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺所在省份" prop="shopProvince">
        <el-input
          v-model="queryParams.shopProvince"
          placeholder="请输入店铺所在省份"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺所在城市" prop="shopCity">
        <el-input
          v-model="queryParams.shopCity"
          placeholder="请输入店铺所在城市"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺所在街道" prop="shopStreet">
        <el-input
          v-model="queryParams.shopStreet"
          placeholder="请输入店铺所在街道"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['petadmin:shoplist:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['petadmin:shoplist:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['petadmin:shoplist:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['petadmin:shoplist:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="shoplistList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="店铺id" align="center" prop="id" />
      <el-table-column label="店铺名" align="center" prop="shopName" />
      <el-table-column label="店铺头像" align="center" prop="shopImg" />
      <el-table-column label="店铺评分" align="center" prop="shopStar" />
      <el-table-column label="店铺所在省份" align="center" prop="shopProvince" />
      <el-table-column label="店铺所在城市" align="center" prop="shopCity" />
      <el-table-column label="店铺所在街道" align="center" prop="shopStreet" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['petadmin:shoplist:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['petadmin:shoplist:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改商家信息增删改对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="店铺名" prop="shopName">
          <el-input v-model="form.shopName" placeholder="请输入店铺名" />
        </el-form-item>
        <el-form-item label="店铺头像" prop="shopImg">
          <el-input v-model="form.shopImg" placeholder="请输入店铺头像" />
        </el-form-item>
        <el-form-item label="店铺评分" prop="shopStar">
          <el-input v-model="form.shopStar" placeholder="请输入店铺评分" />
        </el-form-item>
        <el-form-item label="店铺所在省份" prop="shopProvince">
          <el-input v-model="form.shopProvince" placeholder="请输入店铺所在省份" />
        </el-form-item>
        <el-form-item label="店铺所在城市" prop="shopCity">
          <el-input v-model="form.shopCity" placeholder="请输入店铺所在城市" />
        </el-form-item>
        <el-form-item label="店铺所在街道" prop="shopStreet">
          <el-input v-model="form.shopStreet" placeholder="请输入店铺所在街道" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listShoplist, getShoplist, delShoplist, addShoplist, updateShoplist } from "@/api/petshop/shoplist";

export default {
  name: "Shoplist",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 商家信息增删改表格数据
      shoplistList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        shopName: null,
        shopImg: null,
        shopStar: null,
        shopProvince: null,
        shopCity: null,
        shopStreet: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询商家信息增删改列表 */
    getList() {
      this.loading = true;
      listShoplist(this.queryParams).then(response => {
        this.shoplistList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        shopName: null,
        shopImg: null,
        shopStar: null,
        shopProvince: null,
        shopCity: null,
        shopStreet: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加商家信息增删改";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getShoplist(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改商家信息增删改";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateShoplist(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addShoplist(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除商家信息增删改编号为"' + ids + '"的数据项？').then(function() {
        return delShoplist(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('petadmin/shoplist/export', {
        ...this.queryParams
      }, `shoplist_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
