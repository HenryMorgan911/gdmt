package com.joys.gdmt.Entities.VO;

public class DutyVO {
    private Integer id;
    private String name;
    private String organname;
    private String rolename;

    public DutyVO() {
    }

    public DutyVO(Integer id, String name, String organname, String rolename) {
        this.id = id;
        this.name = name;
        this.organname = organname;
        this.rolename = rolename;
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

    public String getOrganname() {
        return organname;
    }

    public void setOrganname(String organname) {
        this.organname = organname;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
