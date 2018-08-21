package com.pru.service;

import com.pru.domain.Job;
import com.pru.domain.Service;
import com.pru.produce.Producer;
import com.pru.repository.DefaultRepository;
import org.apache.commons.lang.StringUtils;
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
    private DefaultRepository repository;
    @Autowired
    private Producer producer;

    @Override
    public Job submitJob(String serviceName) {
        Job job = new Job(Service.valueOf(serviceName));
        Job save = repository.save(job);
        String topic = getTopic(save);
        producer.send(topic, save);
        return save;
    }

    @Override
    public Iterable<Job> findAll() {
        return repository.findAll();
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
