package com.example.springredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {

  @Autowired CacheService cacheService;

  @Autowired CacheManager cacheManager;

  @Autowired CacheLocker cacheLocker;

  @RequestMapping("/hello")
  public String hello() {
    for (int i = 0; i < 5; i++) {
      System.out.println(new Date() + " " + cacheService.cacheFunction("i" + i));
    }
    return "world";
  }

  @RequestMapping("/init-blacklist")
  public String initBlackList() {
    for (int i = 0; i < 5; i++) {
      cacheService.initCache("" + i);
    }
    return "done";
  }

  @RequestMapping("/get-list")
  public String getList(@RequestParam(name = "token") String token) {
    return "result:[" + cacheService.get(token) + "]";
  }

  @RequestMapping("/exists")
  public boolean isExists(@RequestParam(name = "token") String token) {
    var result = cacheService.get(token);
    if (token.equals(result)) {
      return true;
    }
    return false;
  }

  @RequestMapping("/test")
  public String test(@RequestParam(name = "token") String token) {
    var result = cacheManager.getCache("blacklist").get(token, String.class);
    System.out.println(result);
    return result;
  }

  @RequestMapping("/lock")
  public boolean lock(@RequestParam(name = "token") String token) {
    return cacheLocker.lock(token);
  }

  @RequestMapping("/release")
  public void release(@RequestParam(name = "token") String token) {
    cacheLocker.release(token);
  }
}
