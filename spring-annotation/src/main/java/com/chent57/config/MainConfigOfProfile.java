package com.chent57.config;

import com.chent57.bean.Yellow;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

// @Profile:
//  Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能；
// 开发环境、测试环境、生产环境；
// 数据源：开发环境->数据库A；测试环境->数据库B；生产环境->数据库C；

// @Profile:指定组件在那个环境的情况下才能被注册到容器中，不指定，任何环境下都能注册这个组件
//  (1)加了环境标识的bean，只有这个环境被激活的时候才能注册到容器中，默认是default环境
//  (2)写在配置类上：只有是指定的环境的时候，整个配置类里面的所有配置才能开始生效
// （3）没有标注环境标识的bean，在任何环境都加载


// 怎么激活特定的环境：
//  （1）可以在IDEA运行配置里面的VM options加如下参数来使用动态的@Profile：-Dspring.profiles.active=test
//  （2）代码方式：创建一个applicationContext->设置需要激活的环境->注册主配置类->自动刷新容器
@Configuration
@PropertySource("classpath:/dbconfig.properites")
public class MainConfigOfProfile implements EmbeddedValueResolverAware {
    @Value("${db.user}")
    private String user;

    private StringValueResolver valueResolver;

    private String driverClass;

    @Profile("test")
    @Bean
    public Yellow yellow() {
        return new Yellow();
    }


    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource= new ComboPooledDataSource();
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(pwd);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://120.24.146.147:3306/test");
        comboPooledDataSource.setDriverClass(driverClass);
        return comboPooledDataSource;
    }

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource= new ComboPooledDataSource();
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(pwd);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://120.24.146.147:3306/test");
        comboPooledDataSource.setDriverClass(driverClass);
        return comboPooledDataSource;
    }

    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSourceProd(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource= new ComboPooledDataSource();
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(pwd);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://120.24.146.147:3306/test");
        comboPooledDataSource.setDriverClass(driverClass);
        return comboPooledDataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.valueResolver = resolver;
        this.driverClass = valueResolver.resolveStringValue("${db.driverClass}");
    }
}
