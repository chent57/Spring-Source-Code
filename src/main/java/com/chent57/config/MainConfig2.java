package com.chent57.config;

import com.chent57.bean.Color;
import com.chent57.bean.ColorFactoryBean;
import com.chent57.bean.Person;
import com.chent57.bean.Red;
import com.chent57.condition.MacCondition;
import com.chent57.condition.MyImportBeanDefinitionRegistrar;
import com.chent57.condition.MyImportSelector;
import com.chent57.condition.WindowCondition;
import org.springframework.context.annotation.*;

@Configuration
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class}) // 导入组件，id默认是组件的全类名
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
    @Conditional(WindowCondition.class)
    @Bean("bill")
    public Person person1() {
        return new Person("Bill Gates", 62);
    }

    @Conditional(MacCondition.class)
    @Bean("jobs")
    public Person person2() {
        return new Person("jobs", -1);
    }


    // 给容器注册组件：
    // 1. 包扫描 + 组件标注注解(@Controller, @Service, @Repository, @Component) -> 局限性：第三方包没加注解，只能用自己写的
    // 2. @Bean(导入第三方包里面的组件)
    // 3. @Import(快速给容器中导入一个组件)
    //    3.1. @Import（要导入到容器中的组件: 容器中就会自动注册这个组件，id默认是全类名
    //    3.2. ImportSelector: 返回需要导入的组件（这个用的比较多）
    //    3.3. ImportBeanDefinitionRegistrar：手动注册Bean到容器中
    // 4. 使用Spring提供的FactoryBean（工厂Bean）
    //    4.1. 默认获取到的是工厂bean调用getObject创建的对象
    //    4.2. 要获取工厂bean本身，需要给id前面加一个&
    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }
}
