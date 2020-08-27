package com.chent57.config;

import com.chent57.Dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// 自动装配：Spring利用以来注入（DI），完成对IOC容器中各个组件的依赖关系进行赋值
// 1. @Autowired自动注入：
// （1）默认优先按照类型去容器中找对应的组件，找到就赋值
// （2）如果找到多个同类型的组件， 再将属性的名称作为组件的id去容器中查找
//  (3) @Qualifier("bookDao")：使用@Qualifier指定要装配的组件的id， 而不是使用属性名
//  (4) 默认一定要将属性赋值好，没有就会报错。怎么实现如果没有就不装配呢？@Autowired(required = false)
//  (5) @Primary：让Spring进行自动装配的时候，默认使用首选的bean。也可以继续使用@Qualifier指定需要装配的bean的名字


// 2. Spring还支持使用@Resource（JSR250）和 @Inject（JSR330-java规范注解）
//  （1）@Resource：可以和@Autowired一样实现自动装配功能，默认是按照组件名称进行装配。不支持@primary功能及@Autowired（require = false）
//   (2) 需要导入javax.inject的包，和@Autowired的功能一样。没有requied=false的功能

// AutowiredAnnotationBeanPostProcessor:解析完成自动装配功能

@Configuration
@ComponentScan({"com.chent57.Service", "com.chent57.Controller", "com.chent57.Dao"})
public class MainConfigOfAutowired {

    @Primary
    @Bean("bookDao2")
    public BookDao bookDao() {
        BookDao bookDao = new BookDao();
        bookDao.setLable("2");
        return bookDao;
    }

}
