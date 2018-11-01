package cn.showurs.example.kafka.producer.controller;

import cn.showurs.example.kafka.producer.kafka.service.KafkaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * Created by CJ on 2018/10/30 16:28.
 */
@RefreshScope
@RestController
@RequestMapping("")
public class ProducerController {
    @Value("${name}")
    private String name;

    private KafkaService processorService;

    public ProducerController(KafkaService processorService) {
        this.processorService = processorService;
    }

    @GetMapping("")
    public String getName() {
        return name;
    }

    @PostMapping(value = "/message")
    public Boolean postMessage(@RequestBody String message) {
        return processorService.send(message);
    }
}
