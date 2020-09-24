package com.chent57.aop;

public class MathCalculator {
    public int div(int i, int j) {
        System.out.println("除法函数被调用！"); // 这是一种耦合的方式
        return i/j;
    }
}
