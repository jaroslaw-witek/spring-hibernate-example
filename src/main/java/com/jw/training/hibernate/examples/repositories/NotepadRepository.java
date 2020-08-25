package com.jw.training.hibernate.examples.repositories;

import com.jw.training.hibernate.examples.entities.Notepad;
import org.springframework.data.repository.CrudRepository;

public interface NotepadRepository extends CrudRepository<Notepad, Long> {
}
