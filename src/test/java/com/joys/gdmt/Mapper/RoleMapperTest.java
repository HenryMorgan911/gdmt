package com.joys.gdmt.Mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RoleMapperTest {
    @Autowired
    RoleMapper mapper;

    @Test
    void test() {
        mapper.DeleteRoleRes(3);
    }
}