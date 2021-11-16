package com.chent57.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.AliasFor;

import java.util.Arrays;

/**
 * 切面类
 * @author trentchen
 * @Aspect：告诉Spring当前类是一个切面类
 */
@Aspect
public class LogAspects {


    /**
     * 抽取公共的切入点表达式
     * 1. 如果在本类引用
     * 2. 其他的切面引用，则使用全名（com.chent57.aop.LogAspects.pointCut）
     */
    @Pointcut("execution(public int com.chent57.aop.MathCalculator.*(..))")
    public void pointCut() {};


    /**
     * @Before:在目标方法之前切入；切入点表达式（指定在那个方法切入）,指定类的所有方法用*,两个点表示不指定参数
     * @param joinPoint jointpoint
     */
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) { // JoinPoint必须在参数表第一位
        System.out.println("@Before 除法开始！");
        System.out.println("@Before 方法名：" + joinPoint.getSignature() + "  " + "参数表：" + Arrays.asList(joinPoint.getArgs()));
    }

    @After("execution(public int com.chent57.aop.MathCalculator.*(..))")
    public void logEnd() {
        System.out.println("@After 除法结束！");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(Object result) {
        System.out.println("@AfterReturning 除法正常返回！");
        System.out.println("@AfterReturning 除法返回结果是：" + result);


    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(Exception exception) {
        System.out.println("@AfterThrowing！");
        System.out.println("@AfterThrowing 异常信息是：" + exception);
    }

}
