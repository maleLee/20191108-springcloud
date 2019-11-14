package com.aaa.lee.springcloud.controller;

import com.aaa.lee.springcloud.model.Book;
import com.aaa.lee.springcloud.service.ISpringcloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/12 9:39
 * @Description
 *      在使用feign的时候，springcloud1.x版本可以有多个service接口，但是在springcloud2.x版本之后一个项目只能有一个(feign和hystrix整合的时候最明显)
 *
 **/
@RestController
public class BookController {

    @Autowired
    private ISpringcloudService springcloudService;

    @RequestMapping("/all")
    public List<Book> selectAllBooks() {
        return springcloudService.selectAllBooks();
    }

}
