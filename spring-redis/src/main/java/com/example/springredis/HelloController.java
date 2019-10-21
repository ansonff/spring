package com.example.springredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {

  @Autowired CacheTest cacheTest;

  @RequestMapping("/")
  public String hello() {
    for (int i = 0; i < 5; i++) {
      System.out.println(new Date() + " " + cacheTest.cacheFunction("i"+i));
    }
    return "hello";
  }
}
