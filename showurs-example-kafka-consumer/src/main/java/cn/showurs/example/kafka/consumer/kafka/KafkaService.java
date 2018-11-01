package cn.showurs.example.kafka.consumer.kafka;

import org.springframework.messaging.Message;

/**
 * Created by CJ on 2018/11/1 9:22.
 */
public interface KafkaService {
    Boolean send(String message);
    void receive(Message<String> message);
}
