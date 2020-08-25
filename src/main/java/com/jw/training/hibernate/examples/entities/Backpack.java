package com.jw.training.hibernate.examples.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "backpacks")
public class Backpack {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String brand;

    @OneToMany(mappedBy = "backpack", fetch = FetchType.EAGER)
    private Set<Notepad> notepads;

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
                "Notepads: " + notepadTitles() +
                '}';
    }

    public Set<Notepad> getNotepads() {
        return notepads;
    }

    public void setNotepads(Set<Notepad> notepads) {
        this.notepads = notepads;
    }

    public void addNotepad(Notepad notepad) {
        if (notepads == null) notepads = new HashSet<>();
        notepads.add(notepad);
    }

    private String notepadTitles() {
        return notepads.stream().map(notepad -> String.format("Title: '%s'", notepad.getTitle())).collect(Collectors.toList()).toString();
    }
}
