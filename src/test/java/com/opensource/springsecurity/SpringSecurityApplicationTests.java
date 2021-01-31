package com.opensource.springsecurity;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
		/*
		 * Map<String, Integer> map = Stream.of(new Object[][] { { "data1", 1 }, {
		 * "data2", 2 }, }).collect(Collectors.toMap(data -> (String) data[0], data ->
		 * (Integer) data[1]));
		 */
		Map<String, PasswordEncoder> endcoderMap = Stream
				.of(new Object[][] { { "bcrypt", new BCryptPasswordEncoder() },
						{ "pbkdf2", new Pbkdf2PasswordEncoder() }, { "scrypt", new SCryptPasswordEncoder() }, })
				.collect(Collectors.toMap(data -> (String) data[0], data -> (PasswordEncoder) data[1]));
		System.out.println(new DelegatingPasswordEncoder("bcrypt", endcoderMap).encode(rawPassword));
	}

}
