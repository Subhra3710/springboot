package com.example.Many_To_Many;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ManyToManyApplication {
	private final StudentRepository studentRepository;
	private final SubjectRepository subjectRepository;

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
//			oneWayBinding();
//			Student student1= Student.builder().studentName("Ashit").studentEmail("ashi@gmail.com").build();
//			Student student2= Student.builder().studentName("Bina").studentEmail("binu@gmail.com").build();
//			Student student3= Student.builder().studentName("Arabind").studentEmail("arab@gmail.com").build();
//
//			Subject subject1= Subject.builder().subjectName("HTML").students(List.of(student1,student2)).build();
//			Subject subject2= Subject.builder().subjectName("CSS").students(List.of(student2,student3)).build();
//			Subject subject3= Subject.builder().subjectName("JavaScript").students(List.of(student3,student1)).build();
//			Subject subject4= Subject.builder().subjectName("React").students(List.of(student1)).build();
//
//			student1.setSubjects(List.of(subject1,subject3,subject4));
//			student2.setSubjects(List.of(subject1,subject2));
//			student3.setSubjects(List.of(subject2,subject3));
//			subjectRepository.saveAll(List.of(subject1,subject2,subject3,subject4));

			//Extract
			subjectRepository.findAll().forEach(subject -> {
				subject.getStudents().forEach(student -> {
					System.out.println(student.getStudentName()+"---------> "+subject.getSubjectName());
				});
			});
		};

	}

	private void oneWayBinding(){
//		SAVE
//		Subject subject1 = Subject.builder().subjectName("C").build();
//		Subject subject2 = Subject.builder().subjectName("C++").build();
//		Subject subject3 = Subject.builder().subjectName("Java").build();
//		Subject subject4 = Subject.builder().subjectName("Python").build();
//
//		Student student1 = Student.builder()
//				.studentName("Amit")
//				.studentEmail("amit@gmail.com")
//				.subjects(List.of(subject2, subject3))
//				.build();
//		Student student2 = Student.builder()
//				.studentName("Ankit")
//				.studentEmail("ankit@gmail.com")
//				.subjects(List.of(subject1, subject4))
//				.build();
//		Student student3 = Student.builder()
//				.studentName("Baladev")
//				.studentEmail("baladev@gmail.com")
//				.subjects(List.of(subject1, subject3))
//				.build();
//
//		studentRepository.saveAll(List.of(student1,student2,student3));


//		UPDATE

//		DELETE

//		EXTRACT

		studentRepository.findAll().forEach(student -> {
			System.out.println("student name is:"+student.getStudentName());
			student.getSubjects().forEach(subject-> {
				System.out.println(student.getStudentName() + "\t->\t" + subject.getSubjectName());
			});
		});
	}

}
