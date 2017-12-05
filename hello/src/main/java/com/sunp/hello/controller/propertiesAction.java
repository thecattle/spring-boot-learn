package com.sunp.hello.controller;

import com.sunp.hello.bean.PropertiesModel;
import com.sunp.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableConfigurationProperties({PropertiesModel.class})
@EnableAutoConfiguration
@RequestMapping(value = "/prop")
@RestController
@ConditionalOnClass(HelloWorldService.class)
public class propertiesAction {

    @Autowired
    private PropertiesModel propertiesModel;

    @RequestMapping(value = "/getName")
    public String getName(){

        return propertiesModel.getName();
    }
}
