package com.chent57.test;

import com.chent57.config.MainConfig;

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
}
