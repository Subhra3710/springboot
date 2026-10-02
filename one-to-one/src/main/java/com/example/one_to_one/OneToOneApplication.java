package com.example.one_to_one;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@AllArgsConstructor
@SpringBootApplication
public class OneToOneApplication {

	private final StudentRepository studentRepository;
	private final AddressRepository addressRepository;


	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(){
		return args ->{

//			owningSideOperation();
//			INVERSE SIDE OPERATION;

			Student newStudent = Student.builder().studentName("Baladev").studentEmail("baladev65@gmail.com").build();

			Address newAddress = Address.builder().
					city("Khordha").
					state("Odisha").
					country("India").
					student(newStudent).
					build();

			newStudent.setAddress(newAddress);
			addressRepository.save(newAddress);





//			Address address = Address.builder().city("BBSR")
//					.country("India").build();
//			Student student = Student.builder().studentName("Subhra").studentEmail("s@gmail.com").address(address).build();
//			studentRepository.save(student);
//
//			//Retrieve
//			Student withRoll=studentRepository.findById(2).orElseThrow();
//			System.out.println("Student name:-  "+withRoll.getStudentName());
//			System.out.println("Student Email:-  "+withRoll.getStudentEmail());
//
//			Address studentwithRollAddress=withRoll.getAddress();
//			System.out.println("Address city:- "+studentwithRollAddress.getCity());
//			System.out.println("Address state:- "+studentwithRollAddress.getState());
//			System.out.println("Address country:- "+studentwithRollAddress.getCountry());

//			update
//			Student existingStudent = studentRepository.findById(1).orElseThrow();
//			Address existingAddress = Address.builder().city("CTC").build();
//			existingStudent.setStudentName("arabinda");

//			existingStudent.setAddress(address1);
//			studentRepository.save(existingStudent);
		};

	}

	private void owningSideOperation(){
		Address address = Address.builder().city("BBSR")
					.country("India").build();
			Student student = Student.builder().studentName("Subhra").studentEmail("s@gmail.com").address(address).build();
			studentRepository.save(student);

		// 2. RETRIEVE ADDRESS
		Student existingStudent =
				studentRepository.findById(1).orElseThrow();
		Address existingAddress =
				existingStudent.getAddress();
		System.out.println("City: " + existingAddress.getCity());
		System.out.println("Country: " + existingAddress.getCountry());

		//UPDATE ADDRESS
		existingAddress.setCity("Cuttack");
		existingAddress.setCountry("India");

		studentRepository.save(existingStudent);

		//REMOVE ADDRESS

		existingStudent.setAddress(null);
		studentRepository.save(existingStudent);
	}


	}


