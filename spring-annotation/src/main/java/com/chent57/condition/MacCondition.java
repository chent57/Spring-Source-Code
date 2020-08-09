package com.chent57.condition;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

// 判断是否linux系统
public class MacCondition implements Condition {
    // ConditionContext: 判断条件能使用的上下文环境
    // AnnotatedTypeMetadata：注释信息
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 是否linux系统
        // 1. 获取到ioc使用的beanfactory
        ConfigurableBeanFactory configurableBeanFactory = context.getBeanFactory();
        // 2. 获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        // 3. 获取当前环境
        Environment environment = context.getEnvironment();
        // 4. 获取到bean定义的注册类
        BeanDefinitionRegistry beanDefinitionRegistry = context.getRegistry();

        String property = environment.getProperty("os.name");
        if (property.contains("Mac")) {
            return true;
        }

        return false;
    }
}
