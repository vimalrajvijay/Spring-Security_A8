package com.example.demo_spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello";
	}
	
	@PostMapping("/register")
	public String page1() {
		return "Register Page";
	}
	
	@GetMapping("/home")
	public String page2() {
		return "Home page";
	}
	
	@GetMapping("/user")
	public String userPage() {
		return "User Page";
	}
	
	@GetMapping("/admin")
	public String adminPage() {
		return "Admin Page";
	}
	
}
