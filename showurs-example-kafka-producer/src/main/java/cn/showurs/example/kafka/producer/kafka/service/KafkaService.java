package cn.showurs.example.kafka.producer.kafka.service;

import org.springframework.messaging.Message;

/**
 * Created by CJ on 2018/10/31 14:49.
 */
public interface KafkaService {
    Boolean send(String message);
    void receive(Message<String> message);
}
