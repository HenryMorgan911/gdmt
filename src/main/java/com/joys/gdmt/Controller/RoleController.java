package com.joys.gdmt.Controller;

import com.joys.gdmt.Entities.Role;
import com.joys.gdmt.Entities.VO.RoleCreateVO;
import com.joys.gdmt.Mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Role")
public class RoleController {
    @Autowired
    RoleMapper mapper;

    @PostMapping("insert")
    void insert(@RequestBody RoleCreateVO r) {
        Role role = new Role(r.getName(), r.getResid());
        mapper.insert(role);
        role.getResid().forEach(e -> {
            mapper.RoleRes(role.getId(), e);
        });
    }

    @DeleteMapping("delete")
    void delete(@RequestHeader Integer id) {
        mapper.DeleteRoleRes(id);
        mapper.deleteById(id);
    }

    @PostMapping("update")
    void update(@RequestBody Role role) {
        mapper.DeleteRoleRes(role.getId());
        mapper.updateById(role);
        role.getResid().forEach(e -> {
            mapper.RoleRes(role.getId(), e);
        });
    }

    @GetMapping("list")
    List<Role> list() {
        return mapper.selectList(null);
    }
}
