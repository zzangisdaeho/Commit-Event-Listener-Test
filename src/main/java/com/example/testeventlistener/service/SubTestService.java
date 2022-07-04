package com.example.testeventlistener.service;

import com.example.testeventlistener.entity.TestEntity;
import com.example.testeventlistener.repository.TestEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;


@Transactional(readOnly = true)
@Component
@RequiredArgsConstructor
public class SubTestService {


    private final ApplicationEventPublisher publisher;

    private final TestEntityRepository testEntityRepository;

    @Async
    public void subService(long seq) {

        System.out.println("seq = " + seq);

        TestEntity testEntity = testEntityRepository.findById(seq).get();

        String name = testEntity.getName();

        System.out.println("name = " + name);

    }
}
