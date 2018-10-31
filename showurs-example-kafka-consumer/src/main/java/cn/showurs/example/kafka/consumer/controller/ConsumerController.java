package cn.showurs.example.kafka.consumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CJ on 2018/10/31 9:30.
 */
@RefreshScope
@RestController
@RequestMapping("")
public class ConsumerController {
    @Value("${name}")
    private String name;

    @GetMapping("")
    public String getName() {
        return name;
    }
}
