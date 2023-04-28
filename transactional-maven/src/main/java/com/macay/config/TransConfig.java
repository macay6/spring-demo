package com.macay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @ClassName: TransConfig
 * @Description:
 * @Author: Macay
 * @Date: 2023/4/16 1:55 下午
 */
//@Configuration
//@ComponentScan(value = "com.macay")
//@EnableTransactionManagement
public class TransConfig {
    @Bean
    DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setPassword("123456");
        ds.setUsername("root");
        ds.setUrl("jdbc:mysql:///spring_test?serverTimezone=Asia/Shanghai");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return ds;
    }

    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}
