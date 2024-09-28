package com.example.demo.testutil;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DatabaseProxyTest {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void query() {
        List<DatabaseProxy.Entity> clients = DatabaseProxy.query("SELECT * FROM client", dataSource);
        System.out.println(clients);
    }

    @Test
    void testQuery() {
    }
}