//4.1引入组件
import Vue from 'vue'
import Router from 'vue-router'
import adduser from '../components/adduser.vue'//
import addorgan from '../components/addorgan.vue'
import organ from '../components/organ.vue'
import user from '../components/user.vue'
import addrole from '../components/addrole.vue'
import role from '../components/role.vue'
import addduty from '../components/addduty.vue'
import duty from '../components/duty.vue'
import addres from '../components/addres.vue'
import res from '../components/res.vue'
import OrganTree from '../components/OrganTree.vue'
import resTree from '../components/resTree.vue'
Vue.use(Router)
//搭配路由
export default new Router({
 mode: 'history',
 scrollBehavior: () => ({
 y: 0
 }),
 routes: [
    {
        path:'/adduser',
        name:'adduser',
        component:adduser
    },
    {
        path:'/addorgan',
        name:'addorgan',
        component:addorgan
    },
    {
        path:'/organ',
        name:'organ',
        component:organ
    },
    {
        path:'/user',
        name:'user',
        component:user
    },
    {
        path:'/addrole',
        name:'addrole',
        component:addrole
    },
    {
        path:'/role',
        name:'role',
        component:role
    },
    {
        path:'/addduty',
        name:'addduty',
        component:addduty
    },
    {
        path:'/duty',
        name:'duty',
        component:duty
    },
    {
        path:'/addres',
        name:'addres',
        component:addres
    },
    {
        path:'/res',
        name:'res',
        component:res
    },
    {
        path:'/OrganTree',
        name:'OrganTree',
        component:OrganTree
    },
    {
        path:'/resTree',
        name:'resTree',
        component:resTree
    }
 ]
 
})