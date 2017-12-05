package com.sunp.hello.controller;

import com.sunp.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/starter")
public class CustomizeStarterAction {

    @Autowired
    private HelloWorldService worldService;

    @RequestMapping(value = "/")
    public String getHello(){
        return worldService.getWelcome();
    }
}
