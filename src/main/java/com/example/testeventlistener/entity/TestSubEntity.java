package com.example.testeventlistener.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class TestSubEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long subSeq;

    private String name;

    @ManyToOne
    @JoinColumn(name = "parentSeq")
    private TestEntity parentEntity;
}
