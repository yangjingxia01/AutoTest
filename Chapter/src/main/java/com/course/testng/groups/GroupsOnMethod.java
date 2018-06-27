package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {
    @Test(groups = "server")
    public void test1(){
        System.out.println("这是服务器端组测试的方法test1");
    }
    @Test(groups = "server")
    public void test2(){
        System.out.println("这是服务器端组测试的方法test2");
    }
    @Test(groups = "client")
    public void test3(){
        System.out.println("这是客户端组测试的方法test3");
    }
    @Test(groups = "client")
    public void test4(){
        System.out.println("这是客户端组测试的方法test4");
    }
    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("这是服务器端组测试的方法之前执行--");
    }
    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("这是服务器端组测试的方法之后执行--");
    }
    @BeforeGroups("client")
    public void beforeGroupsOnClient(){
        System.out.println("这是客户端组测试的方法之前执行--");
    }
    @AfterGroups("client")
    public void afterGroupsOnClient(){
        System.out.println("这是客户端组测试的方法之后执行--");
    }
}
