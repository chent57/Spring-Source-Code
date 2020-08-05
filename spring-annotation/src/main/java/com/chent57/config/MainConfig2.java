package com.chent57.config;

import com.chent57.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MainConfig2 {

    @Scope("prototype")
    @Bean("person")
    public Person person() {
        System.out.println("给容器中添加Person");
        return new Person("alice", 25);
    }
}
