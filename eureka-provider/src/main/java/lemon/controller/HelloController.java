package lemon.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("helloWorld")
public class HelloController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping
    public String hello() {
        return serverPort + "hello,world";
    }
}
