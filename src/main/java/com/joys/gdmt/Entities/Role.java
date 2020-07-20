package com.joys.gdmt.Entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

@TableName("role")
public class Role {
    @TableField(exist = false, select = false)
    List<Integer> resid;
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;

    public Role(String name, List<Integer> resid) {
        this.name = name;
        this.resid = resid;
    }


    public Role() {
    }

    public List<Integer> getResid() {
        return resid;
    }

    public void setResid(List<Integer> resid) {
        this.resid = resid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
