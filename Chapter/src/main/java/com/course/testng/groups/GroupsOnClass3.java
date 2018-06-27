package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClass3 {
    public void stu1(){
        System.out.println("GropsOnClass3中的stu1");
    }
    public void stu2(){
        System.out.println("GropsOnClass3中的stu2");
    }
}
