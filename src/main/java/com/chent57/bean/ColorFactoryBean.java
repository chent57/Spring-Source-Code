package com.chent57.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;

// 创建一个Spring定义的FactoryBean
public class ColorFactoryBean implements FactoryBean<Color> {
    // 返回一个Color对象，这个对象会添加到容器中
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean.getObject");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    // true: 这个bean是单例
    // false: 多实例，每次获取都会创建一个新的
    @Override
    public boolean isSingleton() {
        return true;
    }
}
