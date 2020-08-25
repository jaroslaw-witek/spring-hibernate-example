package com.jw.training.hibernate.examples;

import com.jw.training.hibernate.examples.entities.Backpack;
import com.jw.training.hibernate.examples.entities.Student;
import com.jw.training.hibernate.examples.repositories.BackupRepository;
import com.jw.training.hibernate.examples.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//import javax.transaction.Transactional;

@Component
public class SomeComponent {

    private final StudentRepository studentRepository;
    private final BackupRepository backupRepository;

    @Autowired
    public SomeComponent(StudentRepository studentRepository, BackupRepository backupRepository) {
        this.studentRepository = studentRepository;
        this.backupRepository = backupRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void callStuff() {
        try {
//            stuff(true);
//            stuff(false);
            stuff(false);
            stuff(false);
//            stuff(true);
        } catch (Exception ex) {
            System.out.println("BUM!");
        }
    }

    @Transactional
    public void stuff(boolean crash) {

        Backpack backpack = new Backpack();
        backpack.setBrand("Nike");
        backupRepository.save(backpack);

        Student student = new Student();
        student.setName("John Doe");
        student.setBackpack(backpack);

        if (crash) throw new RuntimeException();

        studentRepository.save(student);

//        Object obj = studentRepository.getStudent();
//        studentRepository.getStudent(student.getName()).stream()
//                .forEach(st -> System.out.println(st.toString()));
        //        studentRepository.getStudent(student.getName()).stream()
//                .forEach(System.out::println)
    }
}
