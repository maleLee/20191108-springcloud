package com.aaa.lee.springcloud.service;

import com.aaa.lee.springcloud.mapper.BookMapper;
import com.aaa.lee.springcloud.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/9 8:45
 * @Description
 **/
@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    /**
     * @author Seven Lee
     * @description
     *      查询所有的图书信息
     * @param []
     * @date 2019/11/9
     * @return java.util.List<com.aaa.lee.springcloud.model.Book>
     * @throws
    **/
    public List<Book> selectAll() {
        return bookMapper.selectAll();
    }

}
