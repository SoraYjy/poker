package com.sora.poker.dao.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by yujingyi on 2017/12/26.
 */
@Entity
@Data
@Table(name = "test")
public class TestEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String name;

}
