package com.chent57.config;

import com.chent57.Dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 自动装配：Spring利用以来注入（DI），完成对IOC容器中各个组件的依赖关系进行赋值
// 1. @Autowired自动注入：
// （1）默认优先按照类型去容器中找对应的组件，找到就赋值
// （2）如果找到多个同类型的组件， 再将属性的名称作为组件的id去容器中查找
//  (3)@Qualifier("bookDao")：使用@Qualifier指定要装配的组件的id， 而不是使用属性名

@Configuration
@ComponentScan({"com.chent57.Service", "com.chent57.Controller", "com.chent57.Dao"})
public class MainConfigOfAutowired {

    @Bean("bookDao2")
    public BookDao bookDao() {
        BookDao bookDao = new BookDao();
        bookDao.setLable("2");
        return bookDao;
    }

}
