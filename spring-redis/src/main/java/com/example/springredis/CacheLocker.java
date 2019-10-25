package com.example.springredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CacheLocker {

  private static final String CACHE_NAME = "anti-pass";

  private Object lockObj = new Object();
  @Autowired CacheManager cacheManager;

  public boolean lock(String token) {
    synchronized (lockObj) {
      var value = get(CACHE_NAME, token);
      if (value == null) {
        this.writeCache(token);
        return true;
      } else {
        return false;
      }
    }
  }

  public void release(String token) {
    synchronized (lockObj) {
      cacheManager.getCache(CACHE_NAME).evict(token);
    }
  }

  private void writeCache(String token) {
    cacheManager.getCache(CACHE_NAME).put(token, token);
  }

  /*
  @CachePut(cacheNames = CACHE_NAME, key = "#token")
  public String writeCache(String token) {
    return token;
  }

   */

  private String get(String cacheName, String token) {
    return cacheManager.getCache(cacheName).get(token, String.class);
  }

  //    @Cacheable
}
