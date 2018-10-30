package cn.showurs.example.kafka.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ShowursExampleKafkaConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShowursExampleKafkaConfigApplication.class, args);
    }
}
