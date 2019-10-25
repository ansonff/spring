package com.example.springredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CacheService {

    @Autowired
    CacheManager cacheManager;

  /**
   * 缓存测试方法延时两秒
   *
   * @param i
   * @return
   */
  @Cacheable(value = "cache_test")
  public String cacheFunction(String i) {
    try {
      long time = 2000L;
      Thread.sleep(time);
    } catch (InterruptedException e) {
      throw new IllegalStateException(e);
    }
    return "success" + i;
  }

  @Cacheable(cacheNames = "blacklist", key = "#token", sync = true)
  public String initCache(String token) {
    var value = token;
    return value;
  }

  @Cacheable(cacheNames = "blacklist", key = "#token", sync = true)
  public String get(String token) {
    var value = "";
    return value;
  }






}
