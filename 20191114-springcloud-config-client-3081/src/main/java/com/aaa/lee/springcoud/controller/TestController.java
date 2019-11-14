package com.aaa.lee.springcoud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/14 11:04
 * @Description
 **/
@RestController
public class TestController {

    @Value("${server.port}")
    private String port;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${mybatis.type-aliases-package}")
    private String mybatisTypePackage;

    @RequestMapping("/test")
    public String test() {
        return port + "-----" + driverClassName + "-------" + mybatisTypePackage;
    }

}
