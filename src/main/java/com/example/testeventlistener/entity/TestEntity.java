package com.example.testeventlistener.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seq;

    private String name;

    @OneToMany(mappedBy = "parentEntity", cascade = CascadeType.ALL)
    private List<TestSubEntity> testSubEntityList = new ArrayList<>();

    public void addChild(String name){
        TestSubEntity testSubEntity = new TestSubEntity();
        testSubEntity.setParentEntity(this);
        testSubEntity.setName(name);
        this.testSubEntityList.add(testSubEntity);
    }

}
