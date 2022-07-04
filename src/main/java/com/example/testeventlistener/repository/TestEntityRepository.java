package com.example.testeventlistener.repository;

import com.example.testeventlistener.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestEntityRepository extends JpaRepository<TestEntity, Long> {

}
