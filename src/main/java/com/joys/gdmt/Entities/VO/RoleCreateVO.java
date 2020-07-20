package com.joys.gdmt.Entities.VO;

import java.util.List;

public class RoleCreateVO {
    List<Integer> resid;
    private String name;

    public RoleCreateVO() {
    }

    public RoleCreateVO(String name, List<Integer> resid) {
        this.name = name;
        this.resid = resid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getResid() {
        return resid;
    }

    public void setResid(List<Integer> resid) {
        this.resid = resid;
    }
}
