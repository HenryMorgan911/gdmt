package com.joys.gdmt.Controller;

import com.joys.gdmt.Entities.Duty;
import com.joys.gdmt.Entities.VO.DutyCreateVO;
import com.joys.gdmt.Entities.VO.DutyVO;
import com.joys.gdmt.Mapper.DutyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Duty")
public class DutyController {
    @Autowired
    DutyMapper mapper;

    @PostMapping("/insert")
    void insert(@RequestBody DutyCreateVO d) {
        Duty duty = new Duty(d.getName(), d.getOrganid(), d.getRoleid());
        //System.out.println(duty);
        mapper.insert(duty);
    }

    @DeleteMapping("/delete")
    void delete(@RequestHeader Integer id) {
        mapper.deleteById(id);
        mapper.deleteUserDuty(id);
    }

    @PostMapping("/update")
    void update(@RequestBody Duty duty) {
        mapper.updateById(duty);
    }

    @GetMapping("/list")
    List<DutyVO> List() {
        return mapper.dutylist();
    }
}
