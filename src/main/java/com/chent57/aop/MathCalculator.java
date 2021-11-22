package com.chent57.aop;

/**
 * @author trentchen
 */
public class MathCalculator {
    public int div(int i, int j) {
        // 这是一种耦合的方式
        System.out.println("除法函数被调用！");

        return i/j;
    }
}
