package com.example.demo_spring_security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain configureSecurityFilterChain(HttpSecurity http) {
		
//		http.formLogin(form->form.permitAll());
		
		http.httpBasic(Customizer.withDefaults());
		
		http.csrf(csrf->csrf.disable());
		
		http.sessionManagement(session->session
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		http.authorizeHttpRequests(auth->auth
				.requestMatchers("/api/auth/register").permitAll()
				.anyRequest().authenticated());
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
