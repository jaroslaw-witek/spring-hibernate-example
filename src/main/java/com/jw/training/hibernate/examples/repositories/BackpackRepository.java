package com.jw.training.hibernate.examples.repositories;

import com.jw.training.hibernate.examples.entities.Backpack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackpackRepository extends CrudRepository<Backpack, Long> {
}
