package cn.showurs.example.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CJ on 2018/10/30 16:28.
 */
@RefreshScope
@RestController
@RequestMapping("")
public class ProducerController {
    @Value("${name}")
    private String name;

    @GetMapping("")
    public String getName() {
        return name;
    }
}
