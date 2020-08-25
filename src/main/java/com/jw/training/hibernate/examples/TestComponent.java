package com.jw.training.hibernate.examples;

import com.jw.training.hibernate.examples.entities.*;
import com.jw.training.hibernate.examples.repositories.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class TestComponent {

    private final StudentRepository studentRepository;
    private final BackpackRepository backpackRepository;
    private final NotepadRepository notepadRepository;
    private final NoteRepository noteRepository;
    private final ProfessorRepository professorRepository;

    public TestComponent(StudentRepository studentRepository, BackpackRepository backpackRepository, NotepadRepository notepadRepository,
                         NoteRepository noteRepository, ProfessorRepository professorRepository) {
        this.studentRepository = studentRepository;
        this.backpackRepository = backpackRepository;
        this.notepadRepository = notepadRepository;
        this.noteRepository = noteRepository;
        this.professorRepository = professorRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void callStuff() {
        try {
//            stuff(true);
//            testGetStudent();
//            addNotepadsWithBackpack();
//            printNotepads();
            testProfessorsAndStudents();
            printProfessors();
            printStudents();
        } catch (Exception ex) {
            System.out.println("BUM!");
            ex.printStackTrace();
        }
    }

    private void testProfessorsAndStudents() {
        Student student1 = new Student();
        student1.setName("Jarek Witek");

        Student student2 = new Student();
        student2.setName("Marcin Rak");

        Student student3 = new Student();
        student3.setName("Jan Nowak");

        Professor prof1 = new Professor();
        prof1.setName("Przemyslaw");
        prof1.setSurname("Bykowski");
        prof1.setTitle("Imperator");

        Professor prof2 = new Professor();
        prof2.setName("Szkola");
        prof2.setSurname("Zycia");
        prof2.setTitle("Profesor");

        prof1.addStudent(student1);
        prof1.addStudent(student2);

        prof2.addStudent(student1);
        prof2.addStudent(student2);
        prof2.addStudent(student3);

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        professorRepository.save(prof1);
        professorRepository.save(prof2);
    }


    private void printProfessors() {
        System.out.println("--- Printing Professors: ---");
        professorRepository.findAll().forEach(professor -> {
            System.out.println("***");
            System.out.println(professor.toString());
        });
    }

    private void printStudents() {
        System.out.println("--- Printing Students: ---");
        studentRepository.findAll().forEach(student -> {
            System.out.println("***");
            System.out.println(student.toString());
        });
    }

    private void addNotepadsWithBackpack() {

        Backpack backpack = new Backpack();
        backpack.setBrand("The coolest");
        backpackRepository.save(backpack);

        System.out.println("Entered testNotepads");
        Notepad notepad1 = new Notepad();
        notepad1.setTitle("Analiza Matematyczna");
        notepad1.setBackpack(backpack);
        notepadRepository.save(notepad1);

        Notepad notepad2 = new Notepad();
        notepad2.setTitle("Sterowanie procesow ciaglych");
        notepad2.setBackpack(backpack);
        notepadRepository.save(notepad2);


        System.out.println("Moving on to notes...");
        Note note1A = new Note();
        note1A.setNumber(1);
        note1A.setNotepad(notepad1);
        noteRepository.save(note1A);

        Note note1B = new Note();
        note1B.setNumber(2);
        note1B.setNotepad(notepad1);
        noteRepository.save(note1B);

        Note note1C = new Note();
        note1C.setNumber(3);
        note1C.setNotepad(notepad1);
        noteRepository.save(note1C);

        Note note2A = new Note();
        note2A.setNumber(21);
        note2A.setNotepad(notepad2);
        noteRepository.save(note2A);

        Note note2B = new Note();
        note2B.setNumber(22);
        note2B.setNotepad(notepad2);
        noteRepository.save(note2B);

    }

    @Transactional
    public void printNotepads() {
        notepadRepository.findAll().forEach(notepad -> System.out.println(notepad.toString()));
    }

    private void testGetStudent() {
        Backpack backpack = new Backpack();
        backpack.setBrand("Nike");
        backpackRepository.save(backpack);

        Student student = new Student();
        student.setName("John Doe");
        student.setBackpack(backpack);
        studentRepository.save(student);


        studentRepository.getStudentByName("John Doe")
                .ifPresentOrElse(st -> System.out.println("Student found: " + st.toString()), () -> System.out.println("John Doe not found"));
    }

    @Transactional
    public void stuff(boolean crash) {

        Backpack backpack = new Backpack();
        backpack.setBrand("Nike");
        backpackRepository.save(backpack);

        Student student = new Student();
        student.setName("John Doe");
        student.setBackpack(backpack);

        if (crash) throw new RuntimeException();

        studentRepository.save(student);

    }
}
