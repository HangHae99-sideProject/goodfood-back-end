package com.goodfood.goodfood.global.util;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@Disabled
@SpringBootTest
class RedisUtilTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    @DisplayName("redis에 데이터를 String 형식으로 저장한다.")
    void redisKeySave() {
        redisUtil.setString("테스트","테스트 값");

        System.out.println(redisUtil.getString("테스트"));
        assertEquals(redisUtil.getString("테스트"),"테스트 값");
    }

}
