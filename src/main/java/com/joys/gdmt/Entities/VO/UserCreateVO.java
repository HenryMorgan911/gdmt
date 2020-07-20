package com.joys.gdmt.Entities.VO;

import java.util.List;

public class UserCreateVO {
    private String name;
    private String password;
    private String email;
    private String phone;
    private Integer organid;
    private List<Integer> dutyid;

    public List<Integer> getDutyid() {
        return dutyid;
    }

    public void setDutyid(List<Integer> dutyid) {
        this.dutyid = dutyid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getOrganid() {
        return organid;
    }

    public void setOrganid(Integer organid) {
        this.organid = organid;
    }
}
