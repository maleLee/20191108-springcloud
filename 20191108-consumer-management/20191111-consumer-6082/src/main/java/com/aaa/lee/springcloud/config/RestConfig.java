package com.aaa.lee.springcloud.config;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/11 9:59
 * @Description
 *      默认的负载均衡算法是轮询
 *          因为服务器性能太低，导致8082-->8083(会有延迟)-->eureka认为8083宕机--->8082--->8083
 *      是否可以修改ribbon的负载均衡算法？
 *          在RestTemplate的下方去指定算法即可(8种算法)
 *          BestAvailableRule:
 *              选择一个最小并发的服务进行连接
 *              8081: 100
 *              8082: 300
 *              8083: 75
 *          RetryRule:
 *              重试连接
 *              8081
 *              8082
 *              8083
 *              假设consumer首先访问的8081，但是8081宕机，不会再去访问8081，会直接尝试去访问8082，如果8082宕机，再会去尝试访问8083,8083如果服务正常则直接访问结束
 *          RoundRobinRule:(默认的算法)
 *              8081
 *              8082
 *              8083
 *              8081
 *              8082
 *              8083
 *              8081宕机--->返回500
 *              8082
 *              8083
 *              8081宕机--->返回500
 *         RandomRule:随机
 *              8081
 *              8082
 *              8083
 *              之间随意访问，没有限制
 *
 *
 **/
@Configuration
public class RestConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /**
     * @author Seven Lee
     * @description
     *      使用随机的算法实现负载均衡
     *      这是一个负载均衡的实现，但是写在RestTemplate的配置类中了
     *      耦合度比较高
     *          这个类名叫RestConfig.java-->实现restful风格的类--->在这个类中配置了负载均衡的算法
     *          该类的职责就不单一了，并且耦合度相当高，为了实现职责单一化，需要把整个负载均衡的算法单独封装，和RestTemplate解耦
     *
     *      官方文档中明确指出：
     *          负载均衡的算法类，不能和主启动类在同一个包下也不能成为主启动的子包
     *          因为在springboot官网中说明@SpringBootApplication注解不能和@ComponentScan这个注解在同一个包中
     *          @ComponentScan这个注解是springboot所提供的，如果使用的是springboot项目所提供的就无所谓，但是ribbon项目也有一个注解叫@ComponentScan
     *          就会和springboot所提供的注解冲突，所以必须不能和主启动类在同一个包中
     *              eg:
     *                  log4j的jar包冲突
     *                  springboot框架中使用了log4j-->需要添加log4j的jar包
     *                  ribbon项目也使用了log4j的jar包--->就会直接和springboot项目中的log4j的jar包冲突
     *                  --->直接排除一个jar包<exclude></exclude>
     *                  --->直接在项目添加log4j的jar包，把版本号修改为最新，会覆盖其他jar包中的引用
     *
     * @param []
     * @date 2019/11/11
     * @return com.netflix.loadbalancer.RandomRule
     * @throws 
    **/
    /*@Bean
    public RandomRule randomRule() {
        return new RandomRule();
    }*/

}
