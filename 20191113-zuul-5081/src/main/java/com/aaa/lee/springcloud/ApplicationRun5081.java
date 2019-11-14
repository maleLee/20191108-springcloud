package com.aaa.lee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/13 9:33
 * @Description
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ApplicationRun5081 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun5081.class, args);
    }

}
