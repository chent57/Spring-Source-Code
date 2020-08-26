package com.chent57.test;

import com.chent57.Dao.BookDao;
import com.chent57.Service.BookService;
import com.chent57.config.MainConfigOfAutowired;
import com.chent57.config.MainConfigOfLiftCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Autowired {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        BookService bookService = applicationContext.getBean(BookService.class);
        System.out.println(bookService);

        BookDao bookDao = applicationContext.getBean(BookDao.class);
        System.out.println(bookDao);

        applicationContext.close();
    }
}
