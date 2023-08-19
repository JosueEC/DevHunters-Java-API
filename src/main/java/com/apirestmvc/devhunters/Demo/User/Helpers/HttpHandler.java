package com.apirestmvc.devhunters.Demo.User.Helpers;

import com.apirestmvc.devhunters.Demo.User.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class HttpHandler {
	private HashMap<String, Object> response;
	
	public ResponseEntity<Object> send (String message, HttpStatus statusCode) {
		response = new HashMap<>();
		response.put("status", "error");
		response.put("message", message);
		return new ResponseEntity<>(response, statusCode);
	}
	
	public ResponseEntity<Object> send (String message, HttpStatus statusCode, User user) {
		response = new HashMap<>();
		response.put("status", "success");
		response.put("message", message);
		response.put("data", user);
		return new ResponseEntity<>(response, statusCode);
	}
}
