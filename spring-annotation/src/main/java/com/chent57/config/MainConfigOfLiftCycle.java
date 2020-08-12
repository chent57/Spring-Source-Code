package com.chent57.config;

// bean的生命周期： bean创建---初始化---销毁的过程
// 容器管理bean的生命周期
// 我们可以自定义初始化和销毁方法，容器在bean进行到当前生命周期的时候来调用我们定义的初始化和销毁方法

// 构造（对象创建）
// 单例：在容器启动的时候创建对象
// 多例：在每次获取的时候创建对象

// 初始化和销毁的时机(单实例)
// 初始化：对象创建完成，并赋值好，调用初始化方法
// 销毁：容器关闭的时候销毁（多实例情况，容器不会管理这个bean，容器不会调用销毁方法）


// 1. 指定初始化销毁方法：通过@Bean注解，指定init-method和destory-method

import com.chent57.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MainConfigOfLiftCycle {
    //@Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }
}
