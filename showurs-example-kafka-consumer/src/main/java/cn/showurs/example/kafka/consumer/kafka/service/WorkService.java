package cn.showurs.example.kafka.consumer.kafka.service;

import cn.showurs.example.kafka.consumer.dto.Work;
import org.springframework.messaging.Message;

/**
 * Created by CJ on 2018/11/1 16:32.
 */
public interface WorkService {
    Boolean commitWork(Work work);
    void receiveWork(Message<Work> message);
}
