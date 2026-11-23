package com.example.demo_spring_security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain configureSecurityFilterChain(HttpSecurity http) {
		
//		http.formLogin(form->form.permitAll());
		
		http.httpBasic(Customizer.withDefaults());
		
		http.authorizeHttpRequests(auth->auth
				.requestMatchers("/register").permitAll()
				.anyRequest().authenticated());
		
		return http.build();
	}
}
