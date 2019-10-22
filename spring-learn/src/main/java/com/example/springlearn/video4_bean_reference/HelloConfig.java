package com.example.springlearn.video4_bean_reference;

import com.example.springlearn.video4_bean_reference.bean.HelloBean;
import com.example.springlearn.video4_bean_reference.bean.WorldBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {

    @Bean
    public HelloBean helloBean(WorldBean worldBean){
        var bean= new HelloBean();
        bean.setId("1");
        bean.setName("hello "+ worldBean);
        return bean;
    }

    @Bean
    public WorldBean worldBean(){
        var b = new WorldBean();
        b.setContent("World");
        return b;
    }
}
