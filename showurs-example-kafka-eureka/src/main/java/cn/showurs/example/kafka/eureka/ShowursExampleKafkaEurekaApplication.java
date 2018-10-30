package cn.showurs.example.kafka.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ShowursExampleKafkaEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShowursExampleKafkaEurekaApplication.class, args);
    }
}
