<template>
  <el-container>
    <el-header>
      新增用户信息
    </el-header>
    <el-main>
      <el-form
        ref="form"
        :model="formdata"
        :rules="formrules"
        status-icon
        label-width="80px"
      >
        <el-form-item label="用户名" prop="name" style="margin-left:26%">
          <el-input
            v-model="formdata.name"
            maxlength="20"
            style="width:50%;float:left"
            suffix-icon="el-icon-user-solid"
            show-word-limit
          ></el-input>
        </el-form-item>
        <el-form-item label="密码" style="margin-left:26%">
          <el-input
            v-model="formdata.password"
            minlength="4"
            maxlength="20"
            style="width:50%;float:left"
            show-password
          ></el-input>
        </el-form-item>
        <el-form-item label="邮箱" style="margin-left:26%">
          <el-input
            v-model="formdata.email"
            suffix-icon="el-icon-s-promotion"
            style="width:50%;float:left"
          ></el-input>
        </el-form-item>
        <el-form-item label="手机" style="margin-left:26%">
          <el-input
            v-model="formdata.phone"
            style="width:50%;float:left"
            suffix-icon="el-icon-phone"
          ></el-input>
        </el-form-item>
        <el-form-item label="所属组织" style="margin-left:26%">
          <el-select
            v-model="formdata.organid"
            style="width:50%;float:left"
            @change="getduty"
            placeholder="请选择组织类型"
            class="orgselect"
            slot-scope="scope"
          >
            <el-option
              size="medium"
              v-for="item in organlist"
              :key="item.id"
              :label="item.name"
              :value="item.id"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="岗位" style="margin-left:26%">
          <el-select
            v-model="dutys"
            style="width:50%;float:left"
            multiple
            placeholder="请选择岗位"
            class="orgselect"
          >
            <el-option
              size="medium"
              v-for="item in dutylist"
              :key="item.id"
              :label="item.name"
              :value="item.id"
            >
            </el-option>
          </el-select>
        </el-form-item>

        <el-button type="primary" @click="onSubmit('form')">立即创建</el-button>
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
      organlist: [],
      dutylist: [],
      org: null,
      dutys: [],
      formdata: {
        name: "",
        password: "",
        organid: null,
        email: "",
        phone: "",
        duty: ""
      }
    };
  },
  mounted() {
    this.getorgan();
  },
  methods: {
    getorgan() {
      this.axios.get("http://localhost:8081/Organ/All").then(res => {
        this.organlist = res.data;
        //console.log(this.organlist)
      });
    },
    getduty() {
      //console.log(this.organid,111)
      this.organlist.forEach(e => {
        //console.log(e.id)
        if (e.id == this.formdata.organid) {
          this.org = e;
        }
      });
      //console.log(this.org,9999)
      this.axios
        .post("http://localhost:8081/Duty/getbyorgan", this.org)
        .then(res => {
          this.dutylist = res.data;
          //console.log(this.dutylist)
        });
    },
    onSubmit(form) {
      this.formdata.duty = JSON.stringify(this.dutys);
      //console.log(this.formdata);
      this.$refs[form].validate(valid => {
        if (valid) {
          this.axios
            .post("http://localhost:8081/User/insert", this.formdata)
            .then(res => {
              this.$message({
                message: "恭喜你，这是一条成功消息",
                type: "success"
              });
            });
        }
      });
    }
  }
};
</script>
<style>
.el-table td,
.el-table th {
  text-align: center !important;
}

.el-header {
  border-radius: 4px;
  border: 1px solid rgba(228, 242, 234, 0.8);
  box-shadow: 0 0 2px rgba(0, 0, 0, 0.2);
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
