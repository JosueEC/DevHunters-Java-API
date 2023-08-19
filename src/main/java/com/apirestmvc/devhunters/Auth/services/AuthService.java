package com.apirestmvc.devhunters.Auth.services;

import com.apirestmvc.devhunters.Auth.models.AuthResponse;
import com.apirestmvc.devhunters.Auth.models.LoginRequest;
import com.apirestmvc.devhunters.Auth.models.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	public AuthResponse loginUser (LoginRequest request) {
		return new AuthResponse();
	}
	
	public AuthResponse registerUser (RegisterRequest request) {
		return new AuthResponse();
	}
}
