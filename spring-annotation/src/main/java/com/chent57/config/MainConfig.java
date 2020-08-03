package com.chent57.config;

// 配置类（等同于XML配置文件）

import com.chent57.Service.BookService;
import com.chent57.bean.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Configuration // 告诉Spring这是一个配置类
//@ComponentScan(value = "com.chent57", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})}) // value：指定要扫描的包
@ComponentScan(value = "com.chent57", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
}, useDefaultFilters = false)
@ComponentScans(value = {
        @ComponentScan(value = "com.chent57", includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Repository.class}),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
        }, useDefaultFilters = false)
})
// 自定义规则过滤
public class MainConfig {

    @Bean("person") //给容器中注册一个bean（等同于XML中的的bean），类型为返回值类型，id默认是用方法名为id; 也可以在@Bean后面指定
    public Person person01() {
        return new Person("lisi", 20);
    }

}
