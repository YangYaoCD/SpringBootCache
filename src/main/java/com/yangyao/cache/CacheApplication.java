package com.yangyao.cache;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 默认使用ConcurrentMapCacheManager
 * 保存在ConcurrentMap<Object,value>中
 * 开发中使用缓存中间件：redis、memcached、ehcache
 */
@EnableCaching
@SpringBootApplication
public class CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class, args);
    }

}
