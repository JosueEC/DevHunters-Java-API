package com.apirestmvc.devhunters.Demo.User.controllers;

import com.apirestmvc.devhunters.Demo.User.models.User;
import com.apirestmvc.devhunters.Demo.User.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/user")
public class UserController {
	private final UserService userService;
	
	@Autowired
	public UserController (UserService userService) {
		this.userService = userService;
	}
	
	// * http://localhost:3001/api/v1/user [GET]
	@GetMapping
	public List<User> getUsers () {
		return userService.findUsers();
	}
	
	// * http://localhost:3001/api/v1/user/:userID [GET]
	@GetMapping(path = "{userID}")
	public ResponseEntity<Object> getUser (@PathVariable("userID") Long id) {
		return userService.findOneUser(id);
	}
	
	// * http://localhost:3001/api/v1/user [POST]
	@PostMapping
	public ResponseEntity<Object> postUser (@RequestBody User user) {
		return userService.insertUser(user);
	}
	
	// * http://localhost:3001/api/v1/user [PUT]
	@PutMapping
	public ResponseEntity<Object> putUser (@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	// * http://localhost:3001/api/v1/user/:userID [DELETE]
	@DeleteMapping(path = "{userID}")
	public ResponseEntity<Object> deleteUser (@PathVariable("userID") Long id) {
		return userService.deleteUser(id);
	}
}
