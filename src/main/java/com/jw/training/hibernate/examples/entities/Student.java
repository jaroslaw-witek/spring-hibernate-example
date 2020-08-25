package com.jw.training.hibernate.examples.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @OneToOne
    private Backpack backpack;

    @ManyToMany(mappedBy = "students", fetch = FetchType.EAGER)
    private Set<Professor> professors;

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

    public Set<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(Set<Professor> professors) {
        this.professors = professors;
    }

    public void addProfessor(Professor professor) {
        if (professors == null) professors = new HashSet<>();
        professors.add(professor);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", backpack=" + backpack +
                ", professors= " + professorNames() +
                '}';
    }

    private String professorNames() {
        return professors.stream().map(pr -> String.format("%s %s %s ", pr.getTitle(), pr.getName(), pr.getSurname())).collect(Collectors.joining());
    }
}
