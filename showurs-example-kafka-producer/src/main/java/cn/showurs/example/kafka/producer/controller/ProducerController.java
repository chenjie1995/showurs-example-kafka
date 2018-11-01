package cn.showurs.example.kafka.producer.controller;

import cn.showurs.example.kafka.producer.dto.Work;
import cn.showurs.example.kafka.producer.kafka.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by CJ on 2018/10/30 16:28.
 */
@RefreshScope
@RestController
@RequestMapping("")
public class ProducerController {
    @Value("${name}")
    private String name;

    private WorkService workService;

    @Autowired
    public ProducerController(WorkService workService) {
        this.workService = workService;
    }

    @GetMapping("")
    public String getName() {
        return name;
    }

    @PostMapping(value = "/message")
    public Boolean postMessage(@RequestBody String message) {
        Work work = new Work();
        work.setContent(message);
        work.setCreateTime(new Date());
        work.setCreator("boss");
        work.setStatus(0);
        return workService.disWork(work);
    }
}
