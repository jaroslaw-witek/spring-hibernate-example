package com.jw.training.hibernate.examples.entities;

import javax.persistence.*;

@Entity
@Table(name = "backpacks")
public class Backpack {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String brand;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Backpack{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                '}';
    }
}
