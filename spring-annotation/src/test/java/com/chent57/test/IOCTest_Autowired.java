package com.chent57.test;

import com.chent57.Dao.BookDao;
import com.chent57.Service.BookService;
import com.chent57.bean.Boss;
import com.chent57.bean.Car;
import com.chent57.bean.Color;
import com.chent57.config.MainConfigOfAutowired;
import com.chent57.config.MainConfigOfLiftCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IOCTest_Autowired {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
//        BookService bookService = applicationContext.getBean(BookService.class);
//        System.out.println(bookService);

//        BookDao bookDao = applicationContext.getBean(BookDao.class);
//        System.out.println(bookDao);

        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);

        Car car = applicationContext.getBean(Car.class);
        System.out.println(car);

        Color color = applicationContext.getBean(Color.class);
        System.out.println(color);
        applicationContext.close();
    }
}
