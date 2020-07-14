package com.joys.gdmt.Entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.lang.reflect.Type;

@Data
public class User {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    private String name;
    private String password;
    private String organid;
}
