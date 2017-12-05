package com.sunp.configuration;

import com.sunp.prop.HelloProperties;
import com.sunp.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(name = {"com.sunp.service.HelloWorldService"})
@EnableConfigurationProperties(HelloProperties.class)
@ConditionalOnProperty(prefix = "start.hello",value = "enabled",matchIfMissing = true)
public class HelloWorldServiceAutoConfiguration {
    @Autowired
    HelloProperties properties;

    @Bean
    @ConditionalOnMissingBean(HelloWorldService.class)
    public HelloWorldService helloWorldService(){
        HelloWorldService worldService=new HelloWorldService();
        worldService.setWord(properties.getName());
        return worldService;
    }
}


