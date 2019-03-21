package com.lemon.service;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceClientImpl implements HelloServiceClient {
    @Override
    public String hello() {
        return "请求失败，回退hello!";
    }
}
