package com.example.testeventlistener.service;

import com.example.testeventlistener.event_listener.TestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NoTransactionTestService {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public String noTransactionTest(){
        LocalDateTime now = LocalDateTime.now();

        System.out.println("now = " + now);

        TestDto testDto = new TestDto(100L);

        applicationEventPublisher.publishEvent(testDto);

        log.info("yahoo");

        return "success";
    }
}
