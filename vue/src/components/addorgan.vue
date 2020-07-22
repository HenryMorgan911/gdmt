<template>
  <el-container>
    <el-header>
      新增组织信息
    </el-header>
    <el-main>
      <el-form ref="form" :model="form" :rules="formrules" status-icon label-width="80px">
        <el-form-item label="组织名称" prop="name" style="margin-left:24%">
          <el-input
            v-model="form.name"
            maxlength="20"
            style="width:50%;float:left"
          ></el-input>
        </el-form-item>

        <el-form-item label="父组织" style="margin-left:24%">
          <el-select
            v-model="form.pid"
            clearable
            placeholder="请选择"
            style="width:50%;float:left"
          >
            <el-option
              size="medium"
              v-for="item in list"
              :key="item.id"
              :label="item.name"
              :value="item.id"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item style="margin-left:0px;margin-right:15%">
          <el-button type="primary" @click="onSubmit('form')">立即创建</el-button>
        </el-form-item>
      </el-form>
    </el-main>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      formrules: {
        name: [{ required: true, message: "不能为空", trigger: "blur" }]
      },
      form: {
        name: "",
        pid: null
      },
      list: []
    };
  },
  methods: {
    //获取父组织列表
    getlist() {
      this.axios.get("http://localhost:8081/Organ/All").then(res => {
        this.list = res.data;
      });
    },
    onSubmit(form) {
      //console.log(this.form)
      if (this.form.pid == null) {
        this.form.pid = 0;
      }
      
      this.$refs[form].validate(valid => {
        if (valid) {
          this.axios
            .post("http://localhost:8081/Organ/Insert", this.form)
            .then(res => {
              this.$message({
                message: "恭喜你，这是一条成功消息",
                type: "success"
              });
            });
        }
      });
    }
  },
  mounted() {
    this.getlist();
  }
};
</script>

<style>
.el-table td,
.el-table th {
  text-align: center !important;
}

.el-header {
  background-color: #b3c0d1;
  color: #333;
  text-align: center;
  line-height: 60px;
  padding: 0;
  width: 97%;
  margin-left: 1.5%;
}
.el-main {
  width: 98.5%;
  padding: 10px;
  text-align: center;
  margin-left: 0.9%;
}
.orgselect {
  float: left;
}
</style>
