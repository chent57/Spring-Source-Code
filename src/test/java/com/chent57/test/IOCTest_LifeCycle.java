package com.chent57.test;

import com.chent57.config.MainConfigOfLiftCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_LifeCycle {

    @Test
    public void test01() {
        // 1. 创建IOC容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLiftCycle.class);
        System.out.println("容器创建完成...");

        // 获取bean
        //applicationContext.getBean("car");

        // 2. 关闭容器
        applicationContext.close();
    }
}
