package com.example.demo_spring_security.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo_spring_security.entity.User;
import com.example.demo_spring_security.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;

	public User saveUser(User user) {
		
		String hashPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(hashPassword);
		
		user.setRole("USER");
		
		return userRepository.save(user);
	}
}
