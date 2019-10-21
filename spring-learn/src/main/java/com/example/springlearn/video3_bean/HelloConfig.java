package com.example.springlearn.video3_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {

    @Bean
    public HelloBean helloBean(){
        var bean= new HelloBean();
        bean.setId("1");
        bean.setName("hello");
        return bean;
    }
}
