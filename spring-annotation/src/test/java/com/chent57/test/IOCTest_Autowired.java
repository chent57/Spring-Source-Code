package com.chent57.test;

import com.chent57.bean.Boss;
import com.chent57.bean.Car;
import com.chent57.bean.Color;
import com.chent57.config.MainConfigOfAutowired;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

        System.out.println(applicationContext);
        applicationContext.close();
    }
}
