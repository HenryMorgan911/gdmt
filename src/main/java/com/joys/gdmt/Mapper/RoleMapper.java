package com.joys.gdmt.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joys.gdmt.Entities.Role;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper extends BaseMapper<Role> {
    @Select("INSERT INTO roleres (roleid,resid) VALUES (#{roleid},#{resid})")
    void RoleRes(Integer roleid, Integer resid);

    @Select("DELETE FROM roleres WHERE roleid = #{id}")
    void DeleteRoleRes(Integer id);
}
