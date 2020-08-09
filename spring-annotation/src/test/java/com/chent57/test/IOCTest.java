package com.chent57.test;

import com.chent57.bean.Blue;
import com.chent57.bean.Person;
import com.chent57.config.MainConfig;

import com.chent57.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;


import java.util.*;

public class IOCTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);


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

    @Test
    public void test03() {
        // 获取IOC容器环境(Mac OS X)
        ConfigurableEnvironment configurableEnvironment = applicationContext.getEnvironment();
        System.out.println(configurableEnvironment.getProperty("os.name"));

        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name : namesForType) {
            System.out.println(name);
        }

        Map<String, Person> personMap = applicationContext.getBeansOfType(Person.class);
        System.out.println(personMap);
    }


    @Test
    public void test04_Import() {
        printBeans(applicationContext);
        Blue blue = applicationContext.getBean(Blue.class);
        System.out.println(blue);

    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext) {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
}
