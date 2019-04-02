package com.lemon;

import com.lemon.filter.FirstPreFilter;
import com.lemon.filter.PostFilter;
import com.lemon.filter.SecondPreFilter;
import com.lemon.filter.ThirdPreFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableOAuth2Sso
public class ZuulServerApplication extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class, args);
    }

//    @Bean
//    public FirstPreFilter firstPreFilter() {
//        return new FirstPreFilter();
//    }

//    @Bean
//    public SecondPreFilter secondPreFilter() {
//        return new SecondPreFilter();
//    }
//
//
//    @Bean
//    public ThirdPreFilter thirdPreFilter() {
//        return new ThirdPreFilter();
//    }
//
//    @Bean
//    public PostFilter postFilter() {
//        return new PostFilter();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login", "/client/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable();
    }
}
