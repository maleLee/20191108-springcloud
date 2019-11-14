package com.aaa.lee.springcloud.controller;

import com.aaa.lee.springcloud.model.Book;
import com.aaa.lee.springcloud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/9 8:53
 * @Description
 *      以后只要是springcloud的项目，无论是哪一种调用方式，provider中的controller必须是@RestController，如果是@Controller调用不到
 **/
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public List<Book> selectAllBooks()
    {
        System.out.println("8081");
        return bookService.selectAll();
    }



}
