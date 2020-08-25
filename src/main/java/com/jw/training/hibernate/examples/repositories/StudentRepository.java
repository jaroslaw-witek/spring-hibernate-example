package com.jw.training.hibernate.examples.repositories;

import com.jw.training.hibernate.examples.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    Optional<Student> getStudentByName(String name);
}
