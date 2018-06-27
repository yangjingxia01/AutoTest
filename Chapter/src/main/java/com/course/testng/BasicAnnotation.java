package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {
    //最基本的注解，用来标记方法的部分
    @Test
    public void testCase1(){
      System.out.println("这是测试用例1");
    }
    @Test
    public void testCase2(){
        System.out.println("这是测试用例2");
    }
    @BeforeMethod
    public  void beforeMethod(){
        System.out.println("BeforeMethod这是在测试方法之前运行的");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod这是在测试方法之后运行的");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass这是在类运行前运行的");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("afterClass这是在类运行之后运行的");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite测试套件-在类之前");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite测试套件-在类之后");
    }
}
