/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package lemon.controller;

import lemon.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author Eric Zhao
 */
@RestController
public class DemoController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TestService service;

    @GetMapping("/foo")
    public String foo() throws Exception {
        service.test();
        return service.hello(System.currentTimeMillis());
    }

    @GetMapping("/test")
    public String test() throws Exception {
        for (int i = 0; i < 100; i++) {
            Thread entryThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //while (true) {
                        try {
                            TimeUnit.MILLISECONDS.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        String forObject = restTemplate.getForObject("http://127.0.0.1:8888/foo", String.class);
                        System.out.println(forObject);
                    }
               // }
            });
            entryThread.setName("working thread");
            entryThread.start();
        }
        return service.hello(System.currentTimeMillis());
    }


}
