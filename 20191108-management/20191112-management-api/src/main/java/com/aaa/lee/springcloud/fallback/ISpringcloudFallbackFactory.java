package com.aaa.lee.springcloud.fallback;

import com.aaa.lee.springcloud.model.Book;
import com.aaa.lee.springcloud.service.ISpringcloudService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/12 11:54
 * @Description
 **/
@Component
public class ISpringcloudFallbackFactory implements FallbackFactory<ISpringcloudService> {

    @Override
    public ISpringcloudService create(Throwable throwable) {
        return new ISpringcloudService() {
            @Override
            public List<Book> selectAllBooks() {
                System.out.println("我是测试熔断的方法，我被访问了，ISpringCloudService接口中的selectAllBooks方法抛出异常！");
                return null;
            }
        };
    }
}
