package cn.showurs.example.kafka.producer.kafka.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by CJ on 2018/11/1 16:13.
 */
public interface BossWork {
    String DIS_WORK = "dis-work";
    String CHECK_WORK = "check-work";

    //派发工作
    @Output(DIS_WORK)
    MessageChannel disWork();

    //检查工作完成情况
    @Input(CHECK_WORK)
    SubscribableChannel checkWork();
}
