package com.macay.service;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * @ClassName: transferService
 * @Description:
 * @Author: Macay
 * @Date: 2023/4/16 11:25 上午
 */
@Service
public class TransferService2 {

    @Resource
    private JdbcTemplate jdbcTemplate;


    @Transactional
    public void transfer() {
        jdbcTemplate.update("update user set money = ? where username = ?", 9, "zhangsan");
        // int i = 1/0;
    }
}
