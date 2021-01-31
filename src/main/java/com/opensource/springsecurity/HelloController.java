package com.opensource.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "hello security";
	}

	@GetMapping("/bye")
	public String bye() {
		return "bye security";
	}

}
