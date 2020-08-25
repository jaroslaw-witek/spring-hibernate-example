package com.jw.training.hibernate.examples.entities;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @OneToOne
    private Backpack backpack;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", backpack=" + backpack +
                '}';
    }
}
