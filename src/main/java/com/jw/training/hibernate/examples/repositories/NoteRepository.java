package com.jw.training.hibernate.examples.repositories;

import com.jw.training.hibernate.examples.entities.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {


}
