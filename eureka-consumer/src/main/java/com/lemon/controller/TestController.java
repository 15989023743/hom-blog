package com.lemon.controller;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import com.netflix.loadbalancer.reactive.ServerOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {


//    @GetMapping
//    public void callHello() {
//        List<Server> serverList = Lists.newArrayList(new Server("localhost", 8080), new Server("localhost", 8082));
//        ILoadBalancer loadBalancer = LoadBalancerBuilder.newBuilder().buildFixedServerListLoadBalancer(serverList);
//
//
//        for (int i = 0; i < 5; i++) {
//            String result = LoadBalancerCommand.<String>builder().withLoadBalancer(loadBalancer).build().
//                    submit(new ServerOperation<String>() {
//                        @Override
//                        public Observable<String> call(Server server) {
//                            try {
//                                String add = "http://"+server.getHost()+":"+server.getPort()+"/helloWorld";
//                                System.out.println("dizji:"+add);
//                                URL url = new URL(add);
//                                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                                conn.setRequestMethod("GET");
//                                conn.connect();
//                                InputStream io = conn.getInputStream();
//                                return Observable.just(new String("1"));
//                            } catch (Exception e) {
//                                return Observable.error(e);
//                            }
//                        }
//                    }).toBlocking().first();
//        }
//    }
}
