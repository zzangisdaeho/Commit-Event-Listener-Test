package com.example.testeventlistener.service;

import com.example.testeventlistener.entity.TestEntity;
import com.example.testeventlistener.repository.TestEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
@RequiredArgsConstructor
public class TestService2 {

    private final TestEntityRepository testEntityRepository;

    @Transactional
    public void changeName(String name, TestEntity testEntity){

//        TestEntity testEntity1 = testEntityRepository.findById(testEntity.getSeq()).get();
//        TestEntity testEntity2 = testEntityRepository.findById(testEntity.getSeq()).get();

        boolean isActive = TransactionSynchronizationManager.isActualTransactionActive();
        Integer currentTransactionIsolationLevel = TransactionSynchronizationManager.getCurrentTransactionIsolationLevel();
        boolean readOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
        TransactionStatus transactionStatus = TransactionAspectSupport.currentTransactionStatus();

        testEntity.setName(name);
//        testEntity.getTestSubEntityList().get(0).setName("change child");
    }
}
