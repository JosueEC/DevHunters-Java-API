package com.apirestmvc.devhunters.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
@RequiredArgsConstructor
public class AuthController {
	@PostMapping(path = "/login")
	public String login () {
		return "POST login";
	}
	
	@PostMapping(path = "/register")
	public String register () {
		return "POST register";
	}
}
