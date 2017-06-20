package com.store.demo.domain;

import javax.persistence.*;

/**
 * Created by Alavi on 18-06-17.
 */
@Entity
@Table(name = "Sellers")
public class Seller {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private  String  name;
    private   int age;
    private int ci;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }
}
