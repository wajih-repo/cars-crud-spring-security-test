package com.cars.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.cars.test")
@EntityScan("com.cars")
@ComponentScan("com.cars")
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);

//		ApplicationContext ctx = SpringApplication.run(TestApplication.class, args);
//		UserRepository userRepository = ctx.getBean(UserRepository.class);
//		userRepository.save(new Car("Alex", "alex@mail.com"));
//		userRepository.save(new Car("Beatrice", "beatrice@yahoo.com"));
//		userRepository.save(new Car("Charlotte", "charlotte@gmail.com!"));
	}

}
