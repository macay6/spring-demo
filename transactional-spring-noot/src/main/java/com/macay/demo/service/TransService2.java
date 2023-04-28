package com.macay.demo.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName: TransService
 * @Description:
 * @Author: Macay
 * @Date: 2023/4/16 3:25 下午
 */
@Service
public class TransService2 {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.NESTED)
    public void update() {
        jdbcTemplate.update("update user set money = ? where username = ?", 1000, "lisi");
        int i = 1/0;
    }
}
