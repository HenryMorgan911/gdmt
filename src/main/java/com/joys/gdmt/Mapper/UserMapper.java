package com.joys.gdmt.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joys.gdmt.Entities.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {
    @Select("INSERT INTO userduty (userid,dutyid) VALUES (#{userid},#{dutyid})")
    void userduty(Integer userid, Integer dutyid);

    @Select("DELETE FROM userduty WHERE userid = #{id}")
    void deleteUserDuty(Integer id);
}
