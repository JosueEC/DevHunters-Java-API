package com.apirestmvc.devhunters.Auth.services;

import com.apirestmvc.devhunters.Auth.models.AuthResponse;
import com.apirestmvc.devhunters.Auth.models.LoginRequest;
import com.apirestmvc.devhunters.Auth.models.RegisterRequest;
import com.apirestmvc.devhunters.Demo.User.enums.Role;
import com.apirestmvc.devhunters.Demo.User.models.User;
import com.apirestmvc.devhunters.Demo.User.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	private final UserRepository userRepository;
	
	@Autowired
	public AuthService (UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public AuthResponse loginUser (LoginRequest request) {
		return new AuthResponse();
	}
	
	public AuthResponse registerUser (RegisterRequest request) {
		User user = User.builder()
				.name(request.getUsername())
				.email(request.getUsername())
				.password(request.getPassword())
				.role(Role.USER)
				.build();
		
		userRepository.save(user);
		
		return AuthResponse.builder()
				.token(null)
				.build();
	}
}
