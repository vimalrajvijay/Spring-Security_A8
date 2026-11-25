package com.example.demo_spring_security.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo_spring_security.dto.LoginRequest;
import com.example.demo_spring_security.entity.User;
import com.example.demo_spring_security.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	private final AuthenticationManager authenticationManager;

	public User saveUser(User user) {
		
		String hashPassword = passwordEncoder
				.encode(user.getPassword());
		user.setPassword(hashPassword);
		
		user.setRole("USER");
		
		return userRepository.save(user);
	}
	
	public String login(LoginRequest request) {
		
		//Unauthenticated
		Authentication authentication =
				new UsernamePasswordAuthenticationToken(
						request.getUsername(), 
						request.getPassword());
		
		//Authenticated
		Authentication authentication2 
		= authenticationManager.authenticate(authentication);
		
		return "Login Successful";
	}
}
