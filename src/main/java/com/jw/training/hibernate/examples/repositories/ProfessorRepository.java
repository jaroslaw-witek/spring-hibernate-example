package com.jw.training.hibernate.examples.repositories;

import com.jw.training.hibernate.examples.entities.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {
}
