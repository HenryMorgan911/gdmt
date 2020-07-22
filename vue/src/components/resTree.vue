<template>
    <div>
        <!-- <el-button @click="getTree">默认按钮</el-button> -->
        <el-tree
            :data="data"
            show-checkbox
            default-expand-all
            node-key="id"
            ref="tree"
            highlight-current
            :props="defaultProps">
        </el-tree>
    </div>
</template>
<script>
import axios from 'axios'
export default {
    mounted(){
        this.getTree();
    },
    methods:{
        getTree(){
            this.axios
            .get("http://localhost:8081/Res/tree")
            .then(res=>{
                this.data=res.data
                //console.log(this.data)
            })
        }
    },
    data(){
        return {
            data:[],
            defaultProps:{
                children:'children',
                label:'name'
            }
        }
    }
}
</script>