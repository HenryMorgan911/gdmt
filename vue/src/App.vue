<template>
<el-container class="container">

  <el-aside class="left" width="200px">
  <el-row class="tac">
  <el-col :span="24">
    
    <el-menu
      default-active="2"
      class="el-menu-vertical-demo"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
      :unique-opened="true"
      @open="handleOpen"
      @close="handleClose">
      <el-submenu index="1">
        <template slot="title"  >
          <i class="el-icon-location"></i>
          <span >组织管理</span>
        </template>
        <el-menu-item-group style="padding:0 0 0 0">
          <el-menu-item index="/addorgan" @click="goTo('/addorgan')">添加组织</el-menu-item>
          <el-menu-item index="organ" @click="goTo('/organ')">组织结构展示</el-menu-item>
          <el-menu-item index="OrganTree" @click="goTo('/OrganTree')">组织结构树</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
      <el-submenu index="2">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>用户管理</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="/adduser" @click="goTo('/adduser')">添加用户</el-menu-item>
          <el-menu-item index="user" @click="goTo('/user')">用户信息展示</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
      <el-submenu index="3">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>角色管理</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="/addrole" @click="goTo('/addrole')">添加角色</el-menu-item>
          <el-menu-item index="role" @click="goTo('/role')">角色信息展示</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
      <el-submenu index="4">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>岗位管理</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="/addduty" @click="goTo('/addduty')">添加岗位</el-menu-item>
          <el-menu-item index="duty" @click="goTo('/duty')">岗位信息展示</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
      <el-submenu index="5">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>资源管理</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="/addres" @click="goTo('/addres')">添加资源</el-menu-item>
          <el-menu-item index="res" @click="goTo('/res')">资源信息展示</el-menu-item>
          <el-menu-item index="resTree" @click="goTo('/resTree')">资源树</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
  </el-col>
  
</el-row>
  </el-aside>
<el-main class="mid">
  <div class="main">
  <router-view v-if="isRouterAlive"></router-view>
  </div>
</el-main>

</el-container>
</template>

<script>
export default {
  provide(){
    return{
      reload:this.reload
    }
  },
  data() {
    return {
      isRouterAlive: true
    }
  },

  methods: {
    reload(){
      this.isRouterAlive=false
      $nextTick(function(){
        this.isRouterAlive=true
      })
    },
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    goTo(path) {
      this.$router.replace(path);
    }
  }
};
</script>

<style scoped>
.el-col-12{
  width: 15%;
  height: 100%;
}
.el-aside {
    background-color:#545c64;
    color: #333;
    text-align: center;
    line-height: 200px;
    height:98vh;
    width: 200px;
  }
.left{
flex-shrink: 0;
}

.el-menu-vertical-demo{
  padding: 0%
}
.el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
   
  }
.el-menu{
  border-right-width: 0
}
.main{

 flex-grow: 1;
text-align: center;
  
}
</style>