package com.pru.produce;

import com.pru.domain.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger LOG = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, Job> kafkaTemplate;

    public void send(String topic, Job message){
        LOG.info("sending message='{}' to topic='{}'", message, topic);
        kafkaTemplate.send(topic, message);
    }
}
