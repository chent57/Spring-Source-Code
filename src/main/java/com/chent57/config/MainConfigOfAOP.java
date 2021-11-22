package com.chent57.config;


/*
* AOP: （动态代理cglib）
* 指在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式
* 1. 导入AOP某块：Spring AOP（spring-aspects）
* 2. 定义一个业务逻辑类（MathCalculator）：在业务逻辑运行的时候将日志进行打印（方法之前、运行结束后、方法出现异常，等等）
* 3. 定义一个日志切面类（LogAspects）, 切面类里面的方法需要动态感知MathCalculator.div运行到哪里了然后执行
*    通知方法：
*           前置通知(@Before)：logStart，在目标方法（div）运行之前运行
*           后置通知(@After)：logEnd，在目标方法（div）运行之后运行(无论方法正常结束还是异常结束都调用)
*           返回通知(@AfterReturning)：logReturn，在目标方法正常返回之后运行
*           异常通知(@AfterThrowing)：logException，在目标方法出现异常以后运行
*           环绕通知(@Around)：动态代理，手动推进目标方法运行（joinPoint.proceed()）
* 4. 给切面类的目标方法标注何时何地运行（通知注解）
* 5. 将切面类和业务逻辑类（目标方法所在的类）都加入到容器中（@Bean）
* 6. 告诉Spring哪个类是切面类（给切面类加一个注解@Aspect）
* 7. 给配置类加@EnableAspectJAutoProxy，开启基于注解的AOP模式
*       在Spring中很多，有很多@Enablexxx
*
* 三步：
* （1）将业务逻辑组件和切面类都加入到容器中；告诉Spring哪个是切面类（@Aspect）
* （2）在切面类上的每一个通知方法上标注通知注解，告诉Spring何时何地运行（切入点表达式）
* （3）开启基于注解的AOP模式（@EnableAspectJAutoProxy ）
*
*
* AOP原理：（看给容器中注册了什么组件，这个组件什么时候工作，这个组件的功能是什么？）
* @EnableAspectJAutoProxy
* 1. @EnableAspectJAutoProxy是什么？
*       @Import(AspectJAutoProxyRegistrar.class)：给容器导入AspectJAutoProxyRegistrar
*       利用AspectJAutoProxyRegistrar自定义给容器中注册Bean；BeanDefinition
*       internalAutoProxyCreator = AnnotationAwareAspectJAutoProxyCreator
*       给容器中注册一个AnnotationAwareAspectJAutoProxyCreator；
*
* 2. AnnotationAwareAspectJAutoProxyCreator：
*       AnnotationAwareAspectJAutoProxyCreator
*           ->AspectJAwareAdvisorAutoProxyCreator
*               ->AbstractAdvisorAutoProxyCreator
*                   ->AbstractAutoProxyCreator
*                       ->implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
*                       关注后置处理器（在bean初始化完成前后做的事情）、自动装配beanFactory
*
* AbstractAutoProxyCreator.setBeanFactory()
* AbstractAutoProxyCreator.postProcessBeforeInstantiation 有后置处理器的逻辑（postProcessxxx）
*
*
* AbstractAdvisorAutoProxyCreator.setBeanFactory() -> initBeanFactory() // 重写
* AbstractAdvisorAutoProxyCreator 没有后置处理器逻辑
*
*
* AspectJAwareAdvisorAutoProxyCreator 与Bean和postProcessxxx无关
*
*
* AnnotationAwareAspectJAutoProxyCreator.initBeanFactory() // 重写
* AnnotationAwareAspectJAutoProxyCreator没有后置处理器逻辑
*
* 流程：
*   （1）传入配置类，创建IOC容器
*   （2）注册配置类，调用refresh刷新容器
*   （3）registerBeanPostProcessors(beanFactory)；注册Bean的后置处理器，来方便拦截Bean的创建
*           ①先获取IOC容器以及定义了的需要创建对象的所有BeanPostProcessors
*           ②给容器中加别的BeanPostProcessor
*           ③优先注册实现了PriorityOrdered接口的的BeanPostProcessor
*           ④再给容器中注册实现了Ordered接口的BeanPostProcessor
*           ⑤最后给注册没实现优先级接口的BeanPostProcessor
*           ⑥注册BeanPostProcessor，实际就是创建BeanPostProcessor对象，保存到容器中
*               创建internalAutoProxyCreator的BeanPostProcessor[AnnotationAwareAspectJAutoProxyCreator]
*               1. 创建Bean的实例
*               2. populateBean：给Bean的各种属性赋值
*               3. initializeBean：初始化Bean
*                   1). invokeAwareMethods():处理Aware接口的方法回调
*                   2). applyBeanPostProcessorsBeforeInitialization():应用后置处理器的postProcessBeforeInitialization()
*                   3). invokeInitMethods():执行自定义的初始化方法
*                   4). applyBeanPostProcessorsAfterInitialization():执行后置处理器的postProcessAfterInitialization()
*               4. BeanPostProcessor(AnnotationAwareAspectJAutoProxyCreator)创建成功 -> AspectJAdvisorsBuilder
*           ⑦把BeanPostProcessor注册到BeanFactory中：beanFactory.addBeanPostProcessor(postProcessor);
*
*
*
* */

import com.chent57.aop.LogAspects;
import com.chent57.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author trentchen
 */
// 开启基于注解的AOP模式
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

    /**
     * 业务逻辑加入到容器中
     * @return bean
     */
    @Bean
    public MathCalculator calculator() {
        return new MathCalculator();
    }

    /**
     * 切面类加入到容器中
     * @return bean
     */
    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }
}
