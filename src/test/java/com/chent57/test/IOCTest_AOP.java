package com.chent57.test;

import com.chent57.aop.MathCalculator;
import com.chent57.bean.Boss;
import com.chent57.bean.Car;
import com.chent57.bean.Color;
import com.chent57.config.MainConfigOfAOP;
import com.chent57.config.MainConfigOfAutowired;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class IOCTest_AOP {

    @Test
    public void test01() {
        try {
            AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

            MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
            mathCalculator.div(1, 0);
            applicationContext.close();
        } catch (Exception e) {
            log.error("exception", e);
        }

    }
}
