package com.aaa.lee.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/11 11:36
 * @Description
 *      配置类可以使用两个注解，@SpringBootApplication，@Configuration
 *      但是在这个类中必须要使用@Configuration
 *
 *      如果ribbon所提供的负载均衡算法无法满足项目的需求，可以自己定义
 *      自己写算法，只要自己的写的算法实现了Irule这个接口即可
 *      (明天自己写算法)
 **/
//@Configuration
public class RibbonRuleMine {

    /*@Bean
    public IRule randomRule() {
        return new RandomRule();
    }*/

}
