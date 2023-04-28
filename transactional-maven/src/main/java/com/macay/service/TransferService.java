package com.macay.service;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
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
//@Service
public class TransferService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private PlatformTransactionManager transactionManager;

    @Resource
    private TransactionTemplate transactionTemplate;

    public void transfer() {

        // 定义默认的事务属性
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();

        // 获取TransactionStatus
        TransactionStatus status = transactionManager.getTransaction(defaultTransactionDefinition);

        try {
            jdbcTemplate.update("update user set money = ? where username = ?", 9, "zhangsan");
            // int i = 1/0;
            transactionManager.commit(status);
        } catch (DataAccessException e) {
            e.printStackTrace();
            transactionManager.rollback(status);
        }

    }

    public void transfer2() {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    jdbcTemplate.update("update user set money = ? where username = ?", 9, "zhangsan");
                    // int i = 1/0;
                } catch (DataAccessException e) {
                    e.printStackTrace();
                    // 设置当前事务回滚
                    status.setRollbackOnly();
                }
            }
        });
    }

    public void transfer3() {
        jdbcTemplate.update("update user set money = ? where username = ?", 9, "zhangsan");
        // int i = 1/0;
    }
}
