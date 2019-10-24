package com.example.springkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaApplication.class, args);
    }

    @Autowired
    KafkaConsumer kafkaConsumer;

    @Autowired
    KafkaPublisher kafkaPublisher;

    @Bean
    String test(){
        kafkaPublisher.send("hello world");
        return "";
    }


}
