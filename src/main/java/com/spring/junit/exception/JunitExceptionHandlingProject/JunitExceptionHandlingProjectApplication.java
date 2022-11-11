package com.spring.junit.exception.JunitExceptionHandlingProject;

import com.spring.junit.exception.JunitExceptionHandlingProject.model.Employee;
import com.spring.junit.exception.JunitExceptionHandlingProject.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JunitExceptionHandlingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JunitExceptionHandlingProjectApplication.class, args);

	}


	@Bean
	public CommandLineRunner setup(EmployeeRepository repository){
		return (args) -> {
			repository.save(new Employee(1, "Alice", "asdf@email.com", "3wergw5erge"));
			repository.save(new Employee(2, "Bob", "asdf@email.com", "3wergw5erge"));
			repository.save(new Employee(3, "Carol", "asdf@email.com", "3wergw5erge"));
		};
	}

}
