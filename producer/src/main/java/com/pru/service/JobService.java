package com.pru.service;

import com.pru.domain.Job;
import com.pru.domain.Service;
import com.pru.produce.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobService implements DefaultService {

    @Value("${spring.kafka.topic.g1}")
    private String gserviceTopic;
    @Value("${spring.kafka.topic.h1}")
    private String hserviceTopic;
    @Value("${spring.kafka.topic.p1}")
    private String pserviceTopic;
    @Value("${spring.kafka.topic.dev}")
    private String defaultTopic;

    @Autowired
    private Producer producer;

    @Override
    public Job submitJob(String serviceName) {
        Job job = new Job(Service.valueOf(serviceName));
        String topic = getTopic(job);
        producer.send(topic, job);
        return job;
    }

    private String getTopic(Job job) {
        String topic;
        switch (job.getService()) {
            case G1:
                topic = gserviceTopic;
                break;

            case H1:
                topic = hserviceTopic;
                break;

            case P1:
                topic = pserviceTopic;
                break;

            default:
                topic = defaultTopic;
                break;
        }

        return topic;
    }
}
