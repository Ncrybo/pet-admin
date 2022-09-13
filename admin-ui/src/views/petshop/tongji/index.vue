<template>
    <!--1.设置DOM容器，必须要设置宽高，否则不显示-->
    <div id="Charts" ref="Echarts" ></div>
  </template>
  
  <script>
  //2.引入echartjs
  import * as echarts from "echarts";
  
  export default {
    name: "chart",
    data(){
      return{
      }
    },
    created() {
      //方法一：created()延迟加载getChart方法，先加载dom，否则会报错
      //方法二：使用mounted()挂载
      setTimeout(() => {
        this.getChart()
      }, 1000);
    },
    methods:{
      getChart(){
        //3.定义图标对象myChart，初始化echarts实例
        let myChart=echarts.init(this.$refs.Echarts)
        //或 let myChart=echarts.init(document.getElementById("Charts"))
  
        // 4.添加配置项
        let options={
          title: {  //标题
            text: '销售情况',  //主标题文本
            left:'150',
            top:10,
          },
          tooltip: {}, //提示框
          xAxis: {  //配置要在 X 轴显示的项:
            data: ['缅甸猫', '田园猫','暹罗','英短','加菲猫','波斯猫']
          },
          yAxis: {},  //配置要在 Y 轴显示的项:
          series: [
            {
              name: '销量',
              type: 'bar', //bar柱形图 line折线图 pie饼图 scatter散点图
              data: [5, 20, 36, 10, 10, 20]
            }
          ]
        }
        // 5.将配置给myChart
        myChart.setOption(options)
      }
    }
  
  }
  </script>
  
  <style scoped>
  #Charts{
    width: 500px;
    height: 500px;
  }
  </style>
  