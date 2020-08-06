package com.chent57.config;

import com.chent57.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class MainConfig2 {

    //@Scope("prototype")

    @Lazy // 单实例bean默认在容器启动的时候创建对象；当设置为懒加载时，容器启动不创建对象，第一次使用/获取bean再创建对象并初始化
    @Bean("person")
    public Person person() {
        System.out.println("给容器中添加Person");
        return new Person("alice", 25);
    }



    // @Conditional:按照一定条件进行判断，满足条件给容器中注册bean
    // 如果是Window，给容器中注册bill
    // 如果是linux，给容器注册linus
    @Bean("bill")
    public Person person1() {
        return new Person("Bill Gates", 62);
    }

    @Bean("linus")
    public Person person2() {
        return new Person("linus", 48);
    }
}
