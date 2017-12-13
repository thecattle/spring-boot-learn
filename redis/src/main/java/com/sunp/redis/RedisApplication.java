package com.sunp.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
public class RedisApplication implements CommandLineRunner{

	@Autowired
	private StringRedisTemplate template;

	@Autowired
	private RedisTemplate<Object,Object> redisTemplate;


	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		template.opsForValue().set("test-boot","hahaha");
		System.out.println(template.opsForValue().get("test-boot"));

		redisTemplate.opsForValue().set("haha","和黑");
		System.out.println(redisTemplate.opsForValue().get("haha"));

		redisTemplate.opsForValue();
		redisTemplate.opsForList();
		redisTemplate.opsForHash();
		redisTemplate.opsForSet();
		redisTemplate.opsForZSet();
	}
}
