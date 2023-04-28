package com.macay.demo.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @ClassName: TransService
 * @Description:
 * @Author: Macay
 * @Date: 2023/4/16 3:25 下午
 */
@Service
public class TransService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private TransService2 transService2;


    @Transactional
    public void transfer() {
        jdbcTemplate.update("update user set money = ? where username = ?", 1000, "zhangsan");
        transService2.update();
    }

    @Transactional
    public void transfer2() throws IOException {
        jdbcTemplate.update("update user set money = ? where username = ?", 1000, "zhangsan");
        throw new IOException();
    }
}
