package com.lemon.controller;

import com.lemon.service.HelloServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/substitution")
public class SubstitutionController {
    @Autowired
    @Qualifier("remoteRestTemplate")
    private RestTemplate restTemplate;

    @Autowired
    HelloServiceClient helloServiceClient;

    /**
     * 熔断
     *
     * @return
     */
    @GetMapping("/hello3")
    @HystrixCommand(fallbackMethod = "defaultHello",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")})
    public String testHello() {
        System.out.println(helloServiceClient.hello());
        //restTemplate.getForObject("http://LEMON-PROVIDER/helloWorld", String.class)
        return helloServiceClient.hello();
    }

    public String defaultHello() {
        return "fail";
    }


    @GetMapping("/hello2")
    public String callHello2() {
        System.out.println(helloServiceClient.hello());
        //restTemplate.getForObject("http://LEMON-PROVIDER/helloWorld", String.class)
        return helloServiceClient.hello();
    }


    @GetMapping("/hello")
    public String callHello() {
        //System.out.println(helloServiceClient.hello());
        //这种方式需要引入ribbon,注解@LoadBalanced
        String forObject = restTemplate.getForObject("http://LEMON-PROVIDER/helloWorld", String.class);
        return forObject;
    }
}
