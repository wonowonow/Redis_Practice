package com.practice.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, ItemDto> itemDtoRedisTemplate(
            RedisConnectionFactory redisConnectionFactory
    ) {
        RedisTemplate<String, ItemDto> redisTemplate = new RedisTemplate<>();

        redisTemplate.setConnectionFactory(redisConnectionFactory);

        // Key 를 어떤 걸로 직렬화 할 것인가? - String
        redisTemplate.setKeySerializer(RedisSerializer.string());

        // Value 는 어떤 걸로 직렬화를 할 것인가? - json
        redisTemplate.setValueSerializer(RedisSerializer.json());


        return redisTemplate;
    }

    // Spring Session 직렬, 역직렬 바이트 코드 보기 좋게 바꿔주기
    @Bean
    public RedisSerializer<Object> springSessionDefaultRedisSerializer() {
        return RedisSerializer.json();
    }
}
