package com.abedoya.finalTest.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Punkerman on 6/20/2017.
 */
@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private Integer ci;
    private Integer numberCarsSold;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getCi() {
        return ci;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
    }

    public Integer getNumberCarsSold() {
        return numberCarsSold;
    }

    public void setNumberCarsSold(Integer numberCarsSold) {
        this.numberCarsSold = numberCarsSold;
    }
}
