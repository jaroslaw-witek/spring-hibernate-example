package com.jw.training.hibernate.examples.repositories;

import com.jw.training.hibernate.examples.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    //    @Query(value = "select * " +
//            "from students st " +
//            "join backpacks bp on st.backpack=bp.id" +
//            "where st.name=?1")

//    @Query(value = "select st.id, st.name, bp.brand" +
//            "from students st " +
//            "inner join backpacks bp on st.id=bp.id"
//            )
//    Object getStudent();
}
