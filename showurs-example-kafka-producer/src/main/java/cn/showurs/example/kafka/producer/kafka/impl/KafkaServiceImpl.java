package cn.showurs.example.kafka.producer.kafka.impl;

import cn.showurs.example.kafka.producer.kafka.KafkaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * Created by CJ on 2018/10/31 14:52.
 */
@Service
@EnableBinding(Processor.class)
public class KafkaServiceImpl implements KafkaService {
    private Processor processor;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public KafkaServiceImpl(Processor processor) {
        this.processor = processor;
    }

    @Override
    public Boolean send(String message) {
        return processor.output().send(MessageBuilder.withPayload(message).build());
    }

    @Override
    @StreamListener(Processor.INPUT)
    public void receive(Message<String> message) {
        logger.info(message.getPayload());
    }
}
