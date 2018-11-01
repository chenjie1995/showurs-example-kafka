package cn.showurs.example.kafka.producer.kafka.service.impl;

import cn.showurs.example.kafka.producer.dto.Work;
import cn.showurs.example.kafka.producer.kafka.channel.BossWork;
import cn.showurs.example.kafka.producer.kafka.service.WorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * Created by CJ on 2018/11/1 16:46.
 */
@Service
@EnableBinding(BossWork.class)
public class WorkServiceImpl implements WorkService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private BossWork bossWork;

    @Autowired
    public WorkServiceImpl(BossWork bossWork) {
        this.bossWork = bossWork;
    }

    @Override
    public Boolean disWork(Work work) {
        return bossWork.disWork().send(MessageBuilder.withPayload(work).build());
    }

    @Override
    @StreamListener(BossWork.CHECK_WORK)
    public void checkWork(Message<Work> message) {
        logger.info(message.getPayload().toString());
    }
}
