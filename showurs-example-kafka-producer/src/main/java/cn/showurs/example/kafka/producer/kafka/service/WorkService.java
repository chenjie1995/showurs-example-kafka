package cn.showurs.example.kafka.producer.kafka.service;

import cn.showurs.example.kafka.producer.dto.Work;
import org.springframework.messaging.Message;

/**
 * Created by CJ on 2018/11/1 16:32.
 */
public interface WorkService {
    Boolean disWork(Work work);
    void checkWork(Message<Work> message);
}
