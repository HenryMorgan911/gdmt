package com.joys.gdmt.Entities.VO;

import java.util.Date;

public class OrganVO {
    private Integer id;
    private String name;
    private String pname;
    private Date createtime;

    public OrganVO(Integer id, String name, String pname, Date createtime) {
        this.id = id;
        this.name = name;
        this.pname = pname;
        this.createtime = createtime;
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

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
