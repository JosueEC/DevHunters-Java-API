package com.apirestmvc.devhunters.Demo.User.services;

import com.apirestmvc.devhunters.Demo.User.Helpers.HttpHandler;
import com.apirestmvc.devhunters.Demo.User.models.User;
import com.apirestmvc.devhunters.Demo.User.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
	
	public ResponseEntity<Object> updateUser (User user) {
		if (user.getId() == null || user.getId() <= 0) {
			return httpHandler.send("El ID del usuario es requerido", HttpStatus.BAD_REQUEST);
		}
		
		Optional<User> check = userRepository.findById(user.getId());
		if (check.isEmpty()) {
			return httpHandler.send("El usuario no existe", HttpStatus.NOT_FOUND);
		}
		
		userRepository.save(user);
		return httpHandler.send("Usuario actualizado con exito", HttpStatus.ACCEPTED, user);
	}
	
	public ResponseEntity<Object> deleteUser (Long id) {
		if (id == null || id <= 0) {
			return httpHandler.send("El ID del usuario es requerido", HttpStatus.BAD_REQUEST);
		}
		
		Optional<User> check = userRepository.findById(id);
		if (check.isEmpty()) {
			return httpHandler.send("El usuario no existe", HttpStatus.NOT_FOUND);
		}
		
		userRepository.deleteById(id);
		return httpHandler.send("Usuario eliminado exitosamente", HttpStatus.OK, check.get());
	}
}
