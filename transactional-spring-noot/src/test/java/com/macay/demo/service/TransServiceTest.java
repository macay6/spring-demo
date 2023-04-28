package com.macay.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransServiceTest {

    @Resource
    private TransService transService;

    @Test
    void transfer() {
        transService.transfer();
    }
}
