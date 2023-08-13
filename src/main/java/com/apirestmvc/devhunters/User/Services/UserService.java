package com.apirestmvc.devhunters.User.Services;

import com.apirestmvc.devhunters.User.Helpers.HttpHandler;
import com.apirestmvc.devhunters.User.Models.User;
import com.apirestmvc.devhunters.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("ALL")
@Service
public class UserService {
	private final UserRepository userRepository;
	private HttpHandler httpHandler = new HttpHandler();
	
	@Autowired
	public UserService (UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> findUsers () {
		return userRepository.findAll();
	}
	
	public ResponseEntity<Object> findOneUser (Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty()) {
			return httpHandler.send("El usuario no existe", HttpStatus.NOT_FOUND);
		}
		return httpHandler.send("Usuario encontrado", HttpStatus.FOUND, user.get());
	}
	
	public ResponseEntity<Object> insertUser (User user) {
		Optional<User> check = userRepository.findByEmail(user.getEmail());
		
		if (check.isPresent()) {
			return httpHandler.send("El usuario " + check.get().getEmail() + "ya existe", HttpStatus.CONFLICT);
		}
		
		userRepository.save(user);
		return httpHandler.send("Usuario creado con exito", HttpStatus.CREATED, user);
	}
	
	public void updateUser () {
	
	}
	
	public void deleteUser () {
	
	}
}
