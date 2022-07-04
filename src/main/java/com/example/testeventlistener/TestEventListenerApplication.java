package com.example.testeventlistener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TestEventListenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestEventListenerApplication.class, args);
    }

}
