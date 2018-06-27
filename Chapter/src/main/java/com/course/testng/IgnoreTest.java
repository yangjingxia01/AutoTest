package com.course.testng;

import org.testng.annotations.Test;

public class IgnoreTest {
    @Test
    public void test1(){
        System.out.println("这是忽略执行Ignoretest1--");
    }
    @Test(enabled=false)
    public void test2(){
        System.out.println("这是忽略执行Ignoretest2--");
    }
    @Test(enabled=true)
    public void test3(){
        System.out.println("这是忽略执行Ignoretest3--");
    }
}
