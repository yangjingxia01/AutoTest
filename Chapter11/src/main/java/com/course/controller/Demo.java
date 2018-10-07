package com.course.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;

@Log4j
@RestController
@Api(value="v1",description = "这是我的第一个版本的demo")
@RequstMapping("v1")
public class Demo {
    //首先获取一个执行sql语句的对象

    private SqlSessionTemplate template;
    @RequestMapping(value="/getUserCount",method=RequestMethod.GET)
    @ApiOperation(value="可以获取到用户数",httpMethod="GET")
    public int getUserCount() {
        return template.selectOne("getUserCount");
    }

    @RequestMapping(value="/addUser",method=RequestMrthod.Post)
    public int addUser(@RequestBody User user){
        int result=template.insert("addUser",user);
        return result;

    }
    @RequestMapping(value="/updateUser",method=RequestMrthod.Post)
    public int updateUser((@RequestBody User user) {
        return template.update("updateUser", user);
    }
    @RequestMapping(value="/deleteUser",method=ReuqestMethod.GET)
    public int delUser(@RequestParam int id){
        return template.delete("deleteUser",id);
    }
}
