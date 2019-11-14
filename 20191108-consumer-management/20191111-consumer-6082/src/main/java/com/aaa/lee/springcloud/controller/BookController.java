package com.aaa.lee.springcloud.controller;

import com.aaa.lee.springcloud.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/11 10:00
 * @Description
 *      必须要和eureka中Application的值一模一样！
 *      在使用ribbon集成eureka做负载均衡的时候，不再使用原始的地址进行访问，直接使用eureka中的Application的值进行访问
 *      如果需要做负载均衡就必须要把所有的provider的application.name的值保持一致！！！
 **/
@RestController
public class BookController {

    // private static final String URL = "http://localhost:8081/";
    private static final String URL = "http://BOOK-PROVIDER/";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/all")
    public List<Book> selectAllBooks() {
        return restTemplate.getForObject(URL + "all", List.class);
    }

    /**
     * @author Seven Lee
     * @description
     *      报错:
     *          java.lang.IllegalStateException: No instances available for localhost
     *          没有发现localhost实例
     *          ribbon在脱离eureka的时候，是需要正式环境支持的，也就是说每一台的provider的hostname必须不一样，而且不能用localhost
     *          也就是说所有的正式环境都不能访问路径为localhost
     *          下载花生壳(外网映射工具)，windows系统的hosts文件要修改(hostname和ip映射)
     * @param []
     * @date 2019/11/12
     * @return java.util.List<com.aaa.lee.springcloud.model.Book>
     * @throws
    **/
    @GetMapping("/allLB")
    public List<Book> selectUsersByLoadBalance() {
        // 1.通过loadBalancerClient对象获取到所有的服务提供者的信息(8081,8082,8083)
            // application.properties配置文件中book-provider.ribbon.listOfServers=localhost:8081,localhost:8082,localhost:8083
            // 通过8081，8082，8083中spring.application.name获取到
            // serviceId--->key(choose(Object key))
            // key--->spring.application.name的值
            // serviceInstance:每一个Server对象
        ServiceInstance serviceInstance = loadBalancerClient.choose("book-provider");
        // 2.获取server的ip地址
        String host = serviceInstance.getHost();
        System.out.println(host);
        // 3.获取server的port
        int port = serviceInstance.getPort();
        System.out.println(port);
        // ip+port+requestMapping路径
        return restTemplate.getForObject("http://"+host+":"+port+"/all", List.class);

    }

}
