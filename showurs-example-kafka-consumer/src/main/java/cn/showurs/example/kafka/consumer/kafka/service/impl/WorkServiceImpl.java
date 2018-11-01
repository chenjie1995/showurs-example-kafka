package cn.showurs.example.kafka.consumer.kafka.service.impl;

import cn.showurs.example.kafka.consumer.dto.Work;
import cn.showurs.example.kafka.consumer.kafka.channel.StaffWork;
import cn.showurs.example.kafka.consumer.kafka.service.WorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by CJ on 2018/11/1 16:46.
 */
@Service
@EnableBinding(StaffWork.class)
public class WorkServiceImpl implements WorkService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private StaffWork staffWork;

    @Autowired
    public WorkServiceImpl(StaffWork staffWork) {
        this.staffWork = staffWork;
    }

    @Override
    public Boolean commitWork(Work work) {
        logger.info("提交工作：{}", work.toString());
        return staffWork.commitWork().send(MessageBuilder.withPayload(work).build());
    }

    @Override
    @StreamListener(StaffWork.RECEIVE_WORK)
    public void receiveWork(Message<Work> message) {
        try {
            Thread.sleep(3000);
            Work work = message.getPayload();
            logger.info("接收工作：{}", work.toString());
            work.setCompleteTime(new Date());
            work.setCompleter("chenjie");
            work.setStatus(1);
            commitWork(work);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
