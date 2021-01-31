package com.opensource.springsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@SpringBootTest
class SpringSecurityApplicationTests {

	@Test
	void passwordEncoders() {
		String rawPassword = "password";
		System.out.println(new BCryptPasswordEncoder().encode(rawPassword));
		System.out.println(new Pbkdf2PasswordEncoder().encode(rawPassword));
		System.out.println(new SCryptPasswordEncoder().encode(rawPassword));
	}

}
