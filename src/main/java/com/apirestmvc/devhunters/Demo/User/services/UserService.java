package com.apirestmvc.devhunters.Demo.User.services;

import com.apirestmvc.devhunters.Demo.User.helpers.ServerResponse;
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
	
	@Autowired
	public UserService (UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> findUsers () {
		return userRepository.findAll();
	}
	
	public ResponseEntity<ServerResponse> findOneUser (Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty()) {
			return new ResponseEntity<ServerResponse>(new ServerResponse("USER_NOT_FOUND"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ServerResponse>(new ServerResponse(user), HttpStatus.FOUND);
	}
	
	public ResponseEntity<ServerResponse> insertUser (User user) {
		Optional<User> check = userRepository.findByEmail(user.getEmail());
		
		if (check.isPresent()) {
			return new ResponseEntity<ServerResponse>(new ServerResponse("USER_ALREADY_EXISTS"), HttpStatus.CONFLICT);
		}
		
		userRepository.save(user);
		return new ResponseEntity<ServerResponse>(new ServerResponse(user), HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ServerResponse> updateUser (User user) {
		if (user.getId() == null || user.getId() <= 0) {
			return new ResponseEntity<ServerResponse>(new ServerResponse("BAD_REQUEST"), HttpStatus.BAD_REQUEST);
		}
		
		Optional<User> check = userRepository.findById(user.getId());
		if (check.isEmpty()) {
			return new ResponseEntity<ServerResponse>(new ServerResponse("USER_NOT_FOUND"), HttpStatus.NOT_FOUND);
		}
		
		userRepository.save(user);
		return new ResponseEntity<ServerResponse>(new ServerResponse(user), HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ServerResponse> deleteUser (Long id) {
		if (id == null || id <= 0) {
			return new ResponseEntity<ServerResponse>(new ServerResponse("BAD_REQUEST"), HttpStatus.BAD_REQUEST);
		}
		
		Optional<User> check = userRepository.findById(id);
		if (check.isEmpty()) {
			return new ResponseEntity<ServerResponse>(new ServerResponse("USER_NOT_FOUND"), HttpStatus.NOT_FOUND);
		}
		
		userRepository.deleteById(id);
		return new ResponseEntity<ServerResponse>(new ServerResponse(check.get()), HttpStatus.OK);
	}
}
