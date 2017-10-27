package com.skg.service.user;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
@EnableFeignClients
public class UserApiBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(UserApiBootstrap.class).web(true).run(args);    }
}
