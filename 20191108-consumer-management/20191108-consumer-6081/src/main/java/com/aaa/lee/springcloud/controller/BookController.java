package com.aaa.lee.springcloud.controller;

import com.aaa.lee.springcloud.config.RestFulTemplate;
import com.aaa.lee.springcloud.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/9 8:50
 * @Description
 **/
@RestController
public class BookController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/all")
    public List<Book> selectAllBooks() {
        return restTemplate.getForObject("http://localhost:8081/all", List.class);
    }

}
