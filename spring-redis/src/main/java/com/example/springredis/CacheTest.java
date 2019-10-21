package com.example.springredis;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CacheTest {
    /**
     * 缓存测试方法延时两秒
     * @param i
     * @return
     */
    @Cacheable(value = "cache_test")
    public String cacheFunction(String i){
        try {
            long time = 2000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }

        return "success"+ i;
    }
}