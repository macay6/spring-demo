package com.macay.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: DemoTest
 * @Description:
 * @Author: Macay
 * @Date: 2023/4/16 11:36 上午
 */
public class DemoTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        TransferService transferService = context.getBean(TransferService.class);
        transferService.transfer3();
    }
}
