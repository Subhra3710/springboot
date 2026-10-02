package com.example.one_to_one;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ManyToOneApplication {
    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;

    public static void main(String[] args) {
        SpringApplication.run(ManyToOneApplication.class);
    }
    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> {
//            oneWayBinding();


            Teacher newTeacher = Teacher.builder().teacherName("Ankit").build();

            Subject subject1 = Subject.builder().subjectName("HTML").teacher(newTeacher).build();
            Subject subject2 = Subject.builder().subjectName("JS").teacher(newTeacher).build();
            Subject subject3 = Subject.builder().subjectName("Java").teacher(newTeacher).build();

            newTeacher.setSubjects(List.of(subject1, subject2, subject3));

//            teacherRepository.saveAll(List.of(newTeacher));
        };
    }
    private void oneWayBinding(){
//        SAVE
        Teacher teacher = Teacher.builder().teacherName("Amit").build();

        Subject subject1 = Subject.builder().subjectName("C").teacher(teacher).build();
        Subject subject2 = Subject.builder().subjectName("C++").teacher(teacher).build();
        Subject subject3 = Subject.builder().subjectName("Java").teacher(teacher).build();

        subjectRepository.saveAll(List.of(subject1, subject2, subject3));

//        UPDATE

//        DELETE

//        EXTRACT
        subjectRepository.findAll().forEach((Sub) ->{
            System.out.println(subject1.getSubjectName() + "\t->\t"+ subject1.getTeacher().getTeacherName());
            teacherRepository.findById(1)
                    .orElseThrow()
                    .getSubjects()
                    .forEach(sub ->){
                System.out.println(sub.getTeacher().getTeacherName()+"\t->\t"+sub.getSubject);
            };
        });
    }
}
