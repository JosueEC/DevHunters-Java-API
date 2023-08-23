package com.apirestmvc.devhunters.Auth.controllers;

import com.apirestmvc.devhunters.Auth.models.LoginRequest;
import com.apirestmvc.devhunters.Auth.models.RegisterRequest;
import com.apirestmvc.devhunters.Auth.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apirestmvc.devhunters.Auth.models.AuthResponse;
import org.springframework.http.ResponseEntity;

@SuppressWarnings("ALL")
@RestController
@RequestMapping(path = "/auth")
@RequiredArgsConstructor
public class AuthController {
	private final AuthService authService;
	
	@Autowired
	public AuthController (AuthService authService) {
		this.authService = authService;
	}
	/*
	 Aqui tipamos el objeto de la request con nuestra clase LoginRequest, asi
	 mismo la response con nuestra clase AuthResponse. Lo mismo ocurre para el
	 endpoint /register, pero este recibe un objeto de la clase RegisterRequest
	*/
	@PostMapping(path = "/login")
	public ResponseEntity<AuthResponse> login (@RequestBody LoginRequest request) {
		return ResponseEntity.ok(authService.loginUser(request));
	}
	
	@PostMapping(path = "/register")
	public ResponseEntity<AuthResponse> register (@RequestBody RegisterRequest request) {
		return ResponseEntity.ok(authService.registerUser(request));
	}
}
