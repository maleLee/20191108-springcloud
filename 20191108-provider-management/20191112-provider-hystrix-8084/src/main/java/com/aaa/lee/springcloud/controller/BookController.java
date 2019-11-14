package com.aaa.lee.springcloud.controller;

import com.aaa.lee.springcloud.model.Book;
import com.aaa.lee.springcloud.service.BookService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/12 11:27
 * @Description
 **/
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * @author Seven Lee
     * @description
     *      consumer的controller调用service接口
     *      --->service接口映射provider中controller
     *      --->但是provider中的controller抛出异常
     *      --->调用selectAllBooks()备用方法
     *      @HystrixCommand指向后备的方法
     * @param []
     * @date 2019/11/12
     * @return java.util.List<com.aaa.lee.springcloud.model.Book>
     * @throws
    **/
    @GetMapping("/all")
    //@HystrixCommand(fallbackMethod = "selectAllBooksFallBack")
    public List<Book> selectAllBooks() throws Exception {
        List<Book> bookList = bookService.selectAll();
        if(bookList.size() > 0) {
            throw new Exception("模拟异常，测试熔断处理！");
        }
        return bookList;
    }

    /*public List<Book> selectAllBooksFallBack() {
        List<Book> bookList = new ArrayList<Book>();
        Book book = new Book();
        book.setId(100000000L);
        book.setBookName("测试熔断-->图书名称");
        book.setBookPrice(123.23);
        bookList.add(book);
        return bookList;
    }*/

}
