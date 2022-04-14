package com.nttdata.microservicio.springbootregistration.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import com.nttdata.microservicio.springbootregistration.entity.UserEntity;
import com.nttdata.microservicio.springbootregistration.repository.UserRepository;
import com.nttdata.microservicio.springbootregistration.response.UserResponse;
import com.nttdata.microservicio.springbootregistration.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserResponse saveUser(UserEntity userEntity) {
		UserEntity userEntityByEmail = userRepository.findByEmail(userEntity.getEmail());
		if (userEntityByEmail != null)
			throw new RuntimeJsonMappingException("El email ya esta registrado");
		UserResponse userResponse = new UserResponse(userRepository.save(userEntity));
		return userResponse;
	}

	@Override
	public Optional<UserEntity> getUser(UUID userId) {
		return userRepository.findById(userId);
	}
	
	@Override
	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(UUID userId) {
		Optional<UserEntity> userEntityById = userRepository.findById(userId);
		if (userEntityById == null)
			throw new RuntimeJsonMappingException("No existe id para eliminar usuario");
		userRepository.deleteById(userId);

	}

}
