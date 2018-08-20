package com.pru;


import com.pru.domain.Job;
import com.pru.produce.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.concurrent.TimeUnit;

@EnableEurekaClient
@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {
    @Autowired
    private Producer producer;

    @Value("${app.send.interval}")
    private int interval;

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (true){
            Job job = new Job();
            producer.send(job);
            TimeUnit.SECONDS.sleep(interval);
        }
    }
}
