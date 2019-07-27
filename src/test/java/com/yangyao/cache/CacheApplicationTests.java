package com.yangyao.cache;

import com.yangyao.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheApplicationTests {
    @Autowired
    StringRedisTemplate stringRedisTemplate;//k-v都是字符串的
    @Autowired
    RedisTemplate redisTemplate;//k-v都是对象的

    /**
     * redis常见的五大数据类型
     * String(字符串)、List(列表)、Set(集合)、Hash(散列)、ZSet(有序集合)
         * stringRedisTemplate.opsForValue()
         * stringRedisTemplate.opsForList()
         * stringRedisTemplate.opsForSet()
         * stringRedisTemplate.opsForHash()
         * stringRedisTemplate.opsForZSet()
     */
    @Test
    public void contextLoads() {
//        stringRedisTemplate.opsForValue().append("msg","hello");
//        String result=stringRedisTemplate.opsForValue().get("msg");
//        System.out.println(result);
    }

}
