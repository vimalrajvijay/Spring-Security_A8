package com.example.demo_spring_security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_spring_security.dto.LoginRequest;
import com.example.demo_spring_security.entity.User;
import com.example.demo_spring_security.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;

	@PostMapping("/register")
	public ResponseEntity<User> createUser(
			@RequestBody User user){
		User savedUser = authService.saveUser(user);
		return new ResponseEntity<User>(savedUser, 
				HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequest request){
		String message = authService.login(request);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
