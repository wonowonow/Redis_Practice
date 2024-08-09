package com.practice.redis;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisTemplateTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void stringOpsTest() {
        // 문자열 조작을 위한 클래스
        ValueOperations<String, String> ops
                // 지금 RedisTemplate 에 설정 된 타입을 바탕으로
                // Redis 문자열을 조작 할 것이다.
                // 여기서 말하는 String 은 Redis 의 String 이 아니다.
                // 자바에서의 타입을 말하는 것이다.
                // 즉 레디스를 어떤 타입으로 다룰 것인지 정하는 것이다.
                = stringRedisTemplate.opsForValue();

        ops.set("simplekey", "simplevalue");
        System.out.println(ops.get("simplekey"));

        // 집합을 조작하기 위한 클래스
        SetOperations<String, String> setOps
                = stringRedisTemplate.opsForSet();

        setOps.add("hobbies", "games");
        setOps.add("hobbies", "science", "coding", "alcohol");

        System.out.println(setOps.size("hobbies"));

        // Expire 설정
        stringRedisTemplate.expire("hobbies", 10, TimeUnit.SECONDS);
        stringRedisTemplate.delete("simplekey");
    }

    @Autowired
    private RedisTemplate<String, ItemDto> itemRedisTemplate;

    @Test
    public void itemRedisTemplateTest() {
        ValueOperations<String, ItemDto> ops
                = itemRedisTemplate.opsForValue();

        ops.set("my:keyboard", ItemDto.builder().name("Spider").price(10000).description("WOW").build());

        System.out.println(ops.get("my:keyboard"));
    }
}
