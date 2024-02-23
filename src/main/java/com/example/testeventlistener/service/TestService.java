package com.example.testeventlistener.service;

import com.example.testeventlistener.entity.TestEntity;
import com.example.testeventlistener.entity.TestSubEntity;
import com.example.testeventlistener.event_listener.TestDto;
import com.example.testeventlistener.repository.TestEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestEntityRepository testEntityRepository;

    private final ApplicationEventPublisher applicationEventPublisher;
    private final SubTestService subTestService;

    private final EntityManager entityManager;

    private final TestService2 testService2;

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

//    @Transactional
    public void noTransactionRead(long seq){

        boolean isActive = TransactionSynchronizationManager.isActualTransactionActive();
        Integer currentTransactionIsolationLevel = TransactionSynchronizationManager.getCurrentTransactionIsolationLevel();
        boolean readOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();

        boolean actualTransactionActive = TransactionSynchronizationManager.isActualTransactionActive();
        System.out.println("actualTransactionActive = " + actualTransactionActive);

        TestEntity findEntity = testEntityRepository.findById(seq).get();
//        List<TestSubEntity> testSubEntityList = findEntity.getTestSubEntityList();
//        String name = testSubEntityList.get(0).getName();
//        TestEntity findEntity2 = testEntityRepository.findById(seq).get();
//        TestEntity findEntity3 = testEntityRepository.findById(seq).get();
//        TestEntity findEntity4 = testEntityRepository.findById(seq).get();
        testService2.changeName("change name", findEntity);
    }
}
