package com.chent57.test;

import com.chent57.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IOCTest_Profile {

    // 可以在IDEA运行配置里面的VM options加如下参数来使用动态的@Profile：-Dspring.profiles.active=test
    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);

        // 1. 创建一个applicationContext
        // 2. 设置需要激活的环境
        // 3. 注册主配置类
        // 4. 自动刷新容器
        applicationContext.getEnvironment().setActiveProfiles("test", "dev");
        applicationContext.register(MainConfigOfProfile.class);
        applicationContext.refresh();


        String[] namesForType= applicationContext.getBeanNamesForType(DataSource.class);
        for (String type : namesForType) {
            System.out.println(type);
        }
        applicationContext.close();
    }
}
