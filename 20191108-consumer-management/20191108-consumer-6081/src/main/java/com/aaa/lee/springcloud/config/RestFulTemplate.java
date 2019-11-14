package com.aaa.lee.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/9 9:02
 * @Description
 **/
@Configuration
public class RestFulTemplate {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
