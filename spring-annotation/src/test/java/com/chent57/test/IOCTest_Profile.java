package com.chent57.test;

import com.chent57.config.MainConfigOfAutowired;
import com.chent57.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IOCTest_Profile {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);

        String[] namesForType= applicationContext.getBeanNamesForType(DataSource.class);
        for (String type : namesForType) {
            System.out.println(type);
        }
        applicationContext.close();
    }


}
