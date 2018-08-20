package com.pru.consume;

import com.pru.domain.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private static final Logger LOG = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "${app.topic.foo}")
    public void listen(@Payload Job message) {
        LOG.info("received message='{}'", message);
    }
}
