package com.chent57.test;

import com.chent57.config.MainConfig;

import com.chent57.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.*;

public class IOCTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinition = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinition) {
            System.out.println(name);
        }
    }

    // 05
    @Test
    public void test02() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanDefinition = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinition) {
            System.out.println(name);
        }
        // 默认是单例的，ioc容器启动会调用方法(构造函数)创建对象放到ioc容器中，以后每次获取直接从容器中拿（map.get()）
        // 多实例（用@Scope("prototype)设置）：ioc容器启动不会调用方法创建对象放到容器中，每次获取的时候才会调用方法创建对象放到ioc容器中
        System.out.println("ioc容器创建完成");
        Object bean1 = applicationContext.getBean("person");
        Object bean2 = applicationContext.getBean("person");
        System.out.println(bean1 == bean2);
    }
}
