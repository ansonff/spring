package com.example.springlearn;

import com.example.springlearn.video3_bean.Test3;
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

    @Autowired
    Test3 test3;

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            test3.run();

        };
    }

}
