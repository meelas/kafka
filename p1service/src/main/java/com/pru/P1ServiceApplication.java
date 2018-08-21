package com.pru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class P1ServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(P1ServiceApplication.class, args);
    }
}
