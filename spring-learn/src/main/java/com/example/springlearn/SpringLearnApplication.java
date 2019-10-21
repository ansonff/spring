package com.example.springlearn;

import com.example.springlearn.video2_bean.HelloBean;
import com.example.springlearn.video2_bean.Test2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringLearnApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringLearnApplication.class, args);

    }

    @Autowired Test2 test2;

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            test2.run();

        };
    }

}
