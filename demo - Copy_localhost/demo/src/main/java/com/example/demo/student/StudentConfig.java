package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// import org.hibernate.mapping.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for Student entity.
 */
@Configuration
public class StudentConfig {

    /**
        * A bean that implements the CommandLineRunner interface.
        * This interface provides a way to execute code after the Spring Boot application has started.
        * The run() method is called automatically, and it can be used to perform any necessary initialization tasks.
        *
        * @param repository the student repository
        * @return a CommandLineRunner instance
        */
    @Bean
    CommandLineRunner commandLineRunner(
            studentRepository repository){
        return args -> {
            Student mary = new Student(
				"mary",
				"mary.gmail",
				LocalDate.of(1, Month.JANUARY, 3),
				21
	 		);

            Student jane = new Student(
				"jane",
				"jane.gmail",
				LocalDate.of(1, Month.MARCH, 3),
				21
	 		);

            repository.saveAll(List.of(mary,jane));

            // repository.save(mary);
            // repository.save(jane);

        };
    }

}
