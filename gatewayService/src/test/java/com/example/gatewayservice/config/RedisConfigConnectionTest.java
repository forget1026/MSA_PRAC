package com.example.gatewayservice.config;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
class RedisConfigConnectionTest {
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Test
    void redisConnectionTest() {
        final String key = "a";
        final String data = "1";

        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        stringStringValueOperations.set(key, data);

        final String result = stringStringValueOperations.get(key);
        Assertions.assertThat(result).isEqualTo(data);
    }

}