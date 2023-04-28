package com.macay.service;

import com.macay.config.TransConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: DemoTest
 * @Description:
 * @Author: Macay
 * @Date: 2023/4/16 11:36 上午
 */
public class DemoTest2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TransConfig.class);
        TransferService2 transferService = context.getBean(TransferService2.class);
        transferService.transfer();
    }
}
