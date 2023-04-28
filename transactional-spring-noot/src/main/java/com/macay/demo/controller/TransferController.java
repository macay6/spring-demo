package com.macay.demo.controller;

import com.macay.demo.service.TransService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @ClassName: TransferController
 * @Description:
 * @Author: Macay
 * @Date: 2023/4/16 5:38 下午
 */
@RestController
public class TransferController {

    @Resource
    private TransService transService;

    @GetMapping("/hello")
    public void hello() throws IOException {
        transService.transfer2();
    }
}
