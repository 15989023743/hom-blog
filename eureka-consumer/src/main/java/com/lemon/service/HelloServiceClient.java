package com.lemon.service;

import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "LEMON-PROVIDER", path = "/helloWorld", fallback = HelloServiceClientImpl.class)
public interface HelloServiceClient {
    @GetMapping
    public String hello();
}
