package com.jw.training.hibernate.examples.entities;

import javax.persistence.*;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private int number;

    @ManyToOne
    @JoinColumn(name = "notepad_id")
    private Notepad notepad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Notepad getNotepad() {
        return notepad;
    }

    public void setNotepad(Notepad notepad) {
        this.notepad = notepad;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", number=" + number +
                ", notepad=" + notepad.getTitle() +
                '}';
    }
}
