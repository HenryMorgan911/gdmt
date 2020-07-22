<template>
<el-container>
    <el-header >
        资源信息
    </el-header>
    <el-main>
  <el-table
  :row-style="{height:'10px'}"
  :cell-style="{padding:'11px'}"
     :data="keylist.slice((currentPage-1)*pagesize,currentPage*pagesize)"
    style="width: 100%">
    <el-table-column
      label="资源名称"
      width="180">
      <template slot-scope="scope">
        <i class="el-icon-s-home"></i>
        <span style="margin-left: 10px">{{ scope.row.name}}</span>
      </template>
    </el-table-column>
     <el-table-column
      label="父资源目录名称"
      width="180">
      <template slot-scope="scope">
        <i class="el-icon-office-building"></i>
        <span style="margin-left: 10px">{{ scope.row.pname}}</span>
      </template>
    </el-table-column>
     <el-table-column
      label="创建时间"
      width="300">
      <template slot-scope="scope">
        <i class="el-icon-time"></i>
        <span style="margin-left: 10px">{{ scope.row.createtime}}</span>
      </template>
    </el-table-column>
    <el-table-column
      align="right">
      <template  slot="header" slot-scope="scope">
        <el-input
          v-model="search"
          size="mini"
          clearable
          placeholder="输入关键字搜索">
        </el-input>
      </template>
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index,scope.row)"
          >编辑</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
    </el-main>
     <el-footer>
         <el-pagination 
         class="footer"
         @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="currentPage"
            :page-size="pagesize"
            layout="total, sizes, prev, pager, next, jumper"
            :total="tableData.length">
             </el-pagination>
             </el-footer>
  <el-dialog
  title="提示"
  :visible.sync="dialogVisible"
  width="30%">
<el-form >
    <el-form-item label="资源名称">
      <el-input v-model="res.name"></el-input>
    </el-form-item>
    <el-form-item label="父资源名称">
      <el-select v-model="value" clearable placeholder="请选择" style="width:100%">
    <el-option
    size='medium'
      v-for="item in tableData"
      :key="item.id"
      :label="item.name"
      :value="item.id">
    </el-option>
  </el-select>
    </el-form-item>
</el-form>

  <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="updata()">确 定</el-button>
  </span>

</el-dialog>
</el-container>
</template>

<script>
  export default {
    data() {
      return {
        value: '',//选择父绑定对象
        currentPage: 1, //初始页
        pagesize: 10,
        res:{
          id:null,
          name:'',
          pid:null
        },
        count:'',
        search:'',
        keylist:[],
        dialogVisible: false,
        tableData: [],
        
      }
    },
    mounted(){
      this.getlist()
    },
    watch:{
   search: function(val) {
       if (this.search == "") {
         this.getlist()
         
       }else{
         this.axios
        .get("http://localhost:8081/Res/list")
        .then(res=>{
          this.tableData=res.data
          this.keylist=this.tableData.filter(data => !this.search || data.name.toLowerCase().includes(this.search.toLowerCase()))
        })
        // this.keylist=this.tableData.filter(data => !this.search || data.name.toLowerCase().includes(this.search.toLowerCase()))
         //console.log("11111",this.keylist)
       }
    
       //console.log(this.search,999999)
     }
    },
    methods: {
      getlist(){
        this.axios
        .get("http://localhost:8081/Res/list")
        .then(res=>{
          this.tableData=res.data
          this.keylist=this.tableData
        })
      },
      showall(){
        //console.log(this.tableData)
       this.keylist=this.tableData

      },
      handleEdit(index, row) {
        this.count=index;
        this.dialogVisible = true;
        this.res.id=row.id;
        this.res.name=row.name;
        this.value=row.pid;
      },
      handleDelete(row) {
        //console.log(row)
        this.axios.post("http://localhost:8081/Res/delete",row).then(res=>{
          this.$message({
          message: '恭喜你，这是一条成功消息',
          type: 'success'
        })
        this.getlist()
        })
        
      },
      handleSizeChange: function(size) {
      this.pagesize = size;
      //console.log(this.pagesize); //每页下拉显示数据
    },
    handleCurrentChange: function(currentPage) {
      this.currentPage = currentPage;
      //console.log(this.currentPage); //点击第几页
    },
      updata(){
          this.dialogVisible = false;
          if(this.res.id==this.value){
            this.value=0
          }
          this.res.pid=this.value
          if(this.res.pid==null){
            this.res.pid=0
          }
          console.log(this.res)
          this.axios.post("http://localhost:8081/Res/update",this.res).then(res=>{
            this.$message({
              message: '恭喜你，这是一条成功消息',
              type: 'success'
            })
            this.getlist()
          })
      }
    },
  }
</script>
<style scoped>
.el-header {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
    padding: 0;
    width: 97%;
    margin-left: 1.5%;
    border-radius: 4px;
  border: 1px solid rgba(228, 242, 234, 0.8);
    box-shadow: 0 0 2px rgba(0, 0, 0, 0.2);
  }
  .el-container{
      height:92vh;
  }
  .el-footer{
    background-color: rgb(238, 236, 235);
    color: #333;
    text-align: center;
  border-radius: 4px;
  border: 1px solid rgba(228, 242, 234, 0.8);
    box-shadow: 0 0 2px rgba(0, 0, 0, 0.2);
    padding: 0;
    width: 97%;
    margin-left: 1.5%;
  }
  .el-main{
      height:80vh;
      
  }
  .footer{
      margin-top:1.3%;
  }
</style>
<style>
.el-main{
    padding: 10px;
}

</style>