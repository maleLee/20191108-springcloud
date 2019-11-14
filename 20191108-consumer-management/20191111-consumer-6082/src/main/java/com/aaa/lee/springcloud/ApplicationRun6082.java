package com.aaa.lee.springcloud;

import com.aaa.lee.ribbon.RibbonRuleMine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/11 9:56
 * @Description
 *      如果使用自定义的负载均衡算法，必须要在启动类上添加注解@RibbonClient
 *          name:eureka中的Application的属性值
 *              provider中的application.name的值是小写，但是eureka中的Application的值是大写
 *          configuration:自定义的负载均衡的算法配置类
 **/
@SpringBootApplication
@EnableDiscoveryClient
// @RibbonClient(name = "BOOK-PROVIDER", configuration = RibbonRuleMine.class)
public class ApplicationRun6082 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun6082.class, args);
    }

}
