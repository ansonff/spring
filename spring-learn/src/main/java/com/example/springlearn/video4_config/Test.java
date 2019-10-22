package com.example.springlearn.video4_config;

import com.example.springlearn.video4_config.bean.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test {

  @Autowired private Configuration configuration;

  public void run() {
    String expect = "{password=world, user=hello}";
    System.out.println(this.getClass().getName() + ":");
    System.out.println("expect: " + expect);
    System.out.println("actual: " + configuration.getProperties());
  }
}
