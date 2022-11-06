package com.premukkoji.user;

import com.premukkoji.user.entity.User;
import com.premukkoji.user.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.save(User.builder()
					.firstName("John")
					.lastName("Doe")
					.email("john@gmail.com")
					.age(22)
					.build()
			);

			userService.save(User.builder()
					.firstName("Tom")
					.lastName("Doe")
					.email("tom@gmail.com")
					.age(26)
					.build()
			);
		};
	}

}
