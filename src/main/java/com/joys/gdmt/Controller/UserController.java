package com.joys.gdmt.Controller;

import com.joys.gdmt.Entities.User;
import com.joys.gdmt.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("findAll")
    public List<User> findall(){
        return userMapper.selectList(null);
    }
}
