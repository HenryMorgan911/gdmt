package com.joys.gdmt.Controller;

import com.joys.gdmt.Entities.User;
import com.joys.gdmt.Entities.VO.UserCreateVO;
import com.joys.gdmt.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserMapper mapper;

    @GetMapping("findAll")
    public List<User> findall() {
        return mapper.selectList(null);
    }

    @PostMapping("insert")
    public void Insert(@RequestBody UserCreateVO u) {
        //System.out.println(user);
        User user = new User(u.getOrganid(), u.getName(), u.getPassword(), u.getEmail(), u.getPhone(), u.getDutyid());
        mapper.insert(user);
        user.getDutyid().forEach(e -> {
            mapper.userduty(user.getId(), e);
        });
    }

    @DeleteMapping("delete")
    public void delete(@RequestHeader Integer id) {
        mapper.deleteById(id);
        mapper.deleteUserDuty(id);
    }

    @PostMapping("update")
    public void update(@RequestBody User u) {
        mapper.updateById(u);
        mapper.deleteUserDuty(u.getId());
        u.getDutyid().forEach(e -> {
            mapper.userduty(u.getId(), e);
        });
    }
}
