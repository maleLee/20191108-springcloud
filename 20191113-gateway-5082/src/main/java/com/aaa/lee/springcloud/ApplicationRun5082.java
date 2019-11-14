package com.aaa.lee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/13 11:16
 * @Description
 *      maven项目其实默认支持并不是tomcat，默认支持的是jetty
 *      --->jetty-->jboss-->netty
 *      springboot--->undertow
 **/
@SpringBootApplication
public class ApplicationRun5082 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun5082.class, args);
    }

}
