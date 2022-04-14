package com.nttdata.microservicio.springbootregistration.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.microservicio.springbootregistration.entity.UserEntity;
import com.nttdata.microservicio.springbootregistration.response.UserResponse;
import com.nttdata.microservicio.springbootregistration.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/registration", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse createUser(@Valid @RequestBody UserEntity userEntity) throws Exception {
		return userService.saveUser(userEntity);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<UserEntity> getUser(@PathVariable("id") UUID userId) {
		return userService.getUser(userId);
	}

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserEntity> getUsers() {
		return userService.getAllUsers();
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") UUID userId) throws Exception {
		userService.deleteUser(userId);
	}
}
