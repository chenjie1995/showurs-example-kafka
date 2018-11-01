package cn.showurs.example.kafka.consumer.kafka.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by CJ on 2018/11/1 16:13.
 */
public interface StaffWork {
    String RECEIVE_WORK = "receive-work";
    String COMMIT_WORK = "commit-work";

    //提交工作
    @Output(COMMIT_WORK)
    MessageChannel commitWork();

    //接收工作
    @Input(RECEIVE_WORK)
    SubscribableChannel receiveWork();
}
