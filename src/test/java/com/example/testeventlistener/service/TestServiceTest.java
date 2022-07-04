package com.example.testeventlistener.service;

import com.example.testeventlistener.entity.TestEntity;
import com.example.testeventlistener.repository.TestEntityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@SpringBootTest
class TestServiceTest {

    @Autowired
    TestService testService;

    @Autowired
    TestEntityRepository testEntityRepository;

    private long seq;

    @BeforeEach
    @Transactional
    @Commit
    void initData(){
        TestEntity testEntity = new TestEntity();
        testEntity.setName("name1");
        testEntityRepository.save(testEntity);

        this.seq = testEntity.getSeq();
    }

    @Test
    void test1(){

        System.out.println("======================================================");

        testService.mainService(seq);


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}