package com.nttdata.microservicio.springbootregistration.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.nttdata.microservicio.springbootregistration.entity.UserEntity;
import com.nttdata.microservicio.springbootregistration.response.UserResponse;
@Service
public interface UserService {

	UserResponse saveUser(UserEntity userEntity);

	Optional<UserEntity> getUser(UUID userId);

	List<UserEntity> getAllUsers();

	void deleteUser(UUID userId);

}
