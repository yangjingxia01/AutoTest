package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.List;

import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private  String url;
    private ResourceBundle bundle;

    //用来存储cookies信息的变量
    private CookieStore store;
    //加载配置文件
    @BeforeTest
    public void beforeTest(){
        bundle=ResourceBundle.getBundle("application",Locale.CHINA);//只写配置文件名即可
        url=bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        //从配置文件拼接测试的URL
        String uri=bundle.getString("getCookies.uri");
        String testUrl=this.url+uri;
        //测试逻辑代码实现
        HttpGet get=new HttpGet(testUrl);
        HttpClient client=new DefaultHttpClient();
        HttpResponse response=client.execute(get);
        result= EntityUtils.toString(response.getEntity(),"gbk");
        System.out.println(result);

        //获取cookies信息
     this.store=((DefaultHttpClient) client).getCookieStore();
        List<Cookie> cookieList=store.getCookies();
        for(Cookie cookie:cookieList){
            String name=cookie.getName();
            String value=cookie.getValue();
            System.out.println("cookie name="+name+";cookie value="+value);
        }
    }
   //依赖
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException{
     String uri=bundle.getString("test.get.with.cookies");
     String testUrl=this.url+uri;

     HttpGet get= new HttpGet(testUrl);
     DefaultHttpClient client=new DefaultHttpClient();
     //设置cookies信息
        client.setCookieStore(this.store);

        //访问请求，需要抛异常
        HttpResponse response=client.execute(get);
        //取响应状态码
        int statusCode=response.getStatusLine().getStatusCode();
        System.out.println("statusCode="+statusCode);
        if(statusCode==200){
            String result;
            result=EntityUtils.toString(response.getEntity(),"UTF-8");
            System.out.println(result);
        }

    }
}
