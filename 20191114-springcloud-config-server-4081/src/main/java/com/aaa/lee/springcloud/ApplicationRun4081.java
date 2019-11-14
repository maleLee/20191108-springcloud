package com.aaa.lee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/14 9:40
 * @Description
 **/
@SpringBootApplication
@EnableConfigServer
public class ApplicationRun4081 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun4081.class, args);
    }

}
