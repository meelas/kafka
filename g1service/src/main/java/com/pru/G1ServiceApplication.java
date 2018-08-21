package com.pru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class G1ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(G1ServiceApplication.class, args);
    }
}
