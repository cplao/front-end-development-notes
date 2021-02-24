package com.test.admin;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class BootWebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
//        jdbcTemplate.queryForList("select * from employees ");
        long along = jdbcTemplate.queryForObject("select count(*) from employees",long.class);
        log.info("记录总数：{}",along);

        log.info("数据源类型:{}",dataSource.getClass());//查看数据源类型，这里是查看自定义的数据源druid
    }

}
