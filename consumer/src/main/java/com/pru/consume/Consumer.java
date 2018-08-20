package com.pru.consume;

import com.pru.domain.JobDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class Consumer {

    private static final Logger LOG = LoggerFactory.getLogger(Consumer.class);

    private CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "${spring.kafka.topic.dev}")
    public void listen(@Payload JobDto message) {
        LOG.info("received message='{}'", message);
        latch.countDown();
    }
}
