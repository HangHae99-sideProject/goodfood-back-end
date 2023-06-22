package com.goodfood.goodfood.global.util;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Component
public class RedisUtil {

    private final RedisTemplate redisTemplate;

    public void setString(String key, String value){
        redisTemplate.opsForValue().set(key, value);
    }

    public void setString(String key, String value, long timer, TimeUnit unit){
        redisTemplate.opsForValue().set(key, value, timer, unit);
    }

    public String getString(String key){
        return redisTemplate.opsForValue().get(key).toString();
    }

}
