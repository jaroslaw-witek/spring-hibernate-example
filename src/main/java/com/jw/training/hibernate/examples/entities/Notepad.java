package com.jw.training.hibernate.examples.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "notepads")
public class Notepad {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "backpack_id", nullable = false)
    private Backpack backpack;

    @OneToMany(mappedBy = "notepad", fetch = FetchType.EAGER)
    private List<Note> notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }


    @Override
    public String toString() {
        return "Notepad{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", backpack=" + backpack +
                ", notes=" + notes +
                '}';
    }
}
