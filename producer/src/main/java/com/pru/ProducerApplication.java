package com.pru;


import com.pru.domain.Job;
import com.pru.domain.Service;
import com.pru.produce.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.concurrent.TimeUnit;

@EnableEurekaClient
@SpringBootApplication
@RefreshScope
public class ProducerApplication implements CommandLineRunner {
    @Autowired
    private Producer producer;

    @Value("${app.submit.interval}")
    private int interval;
    @Value("${app.send}")
    private boolean submit;
    @Value("${spring.kafka.topic.dev}")
    private String topic;

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (submit){
            Service service = Service.randomService();
            Job job = new Job(service);
            producer.send(topic, job);
            TimeUnit.SECONDS.sleep(interval);
        }
    }
}
