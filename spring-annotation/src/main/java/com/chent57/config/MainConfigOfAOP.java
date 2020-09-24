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
* */

import com.chent57.aop.LogAspects;
import com.chent57.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy // 开启基于注解的AOP模式
@Configuration
public class MainConfigOfAOP {
    // 业务逻辑加入到容器中
    @Bean
    public MathCalculator calculator() {
        return new MathCalculator();
    }

    // 切面类加入到容器中
    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }
}
