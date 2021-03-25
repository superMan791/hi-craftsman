package com.cloud.br.hicraftsman.common.core.config;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO Redis配置
 *
 * @author yzp
 * @date 2020/4/13 0013 8:34
 */
@Configuration
@Slf4j
public class RedissonConfig {
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private Integer port;
    @Value("${spring.redis.password:}")
    private String password;

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://"+host+":"+port).setPassword(password);
        RedissonClient redisson = Redisson.create(config);
        return redisson;

    }
}
