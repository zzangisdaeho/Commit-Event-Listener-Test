package com.example.testeventlistener.service;

import com.example.testeventlistener.entity.TestEntity;
import com.example.testeventlistener.event_listener.TestDto;
import com.example.testeventlistener.repository.TestEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestEntityRepository testEntityRepository;

    private final ApplicationEventPublisher applicationEventPublisher;
    private final SubTestService subTestService;

    private final EntityManager entityManager;

    @Transactional
    public void mainService(long seq){

        boolean actualTransactionActive = TransactionSynchronizationManager.isActualTransactionActive();
        System.out.println("actualTransactionActive = " + actualTransactionActive);

        TestEntity testEntity1 = testEntityRepository.findById(seq).get();

        testEntity1.setName("name2");
        applicationEventPublisher.publishEvent(new TestDto(seq));
        applicationEventPublisher.publishEvent(new TestDto(seq));
        applicationEventPublisher.publishEvent(new TestDto(seq));
        applicationEventPublisher.publishEvent(new TestDto(seq));

        System.out.println("메인은 끝났어");
//        subTestService.test11(seq);

    }
}
