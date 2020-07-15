package com.joys.gdmt.Entities;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("user")
public class User {
    @TableId
    private Integer id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private Integer organid;
}
