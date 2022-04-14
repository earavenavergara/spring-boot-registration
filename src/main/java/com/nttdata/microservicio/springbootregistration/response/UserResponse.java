package com.nttdata.microservicio.springbootregistration.response;

import java.util.Date;
import java.util.UUID;

import com.nttdata.microservicio.springbootregistration.entity.UserEntity;

import lombok.Data;

@Data
public class UserResponse {

	private UUID id;

	private Date created;

	private Date modified;

	private Date last_login;

	private String token;

	private Boolean isactive;

	public UserResponse(UserEntity userEntity) {
		this.id = userEntity.getUserId();
		this.created = userEntity.getCreatedAt();
		this.modified = userEntity.getUpdatedAt();
		this.isactive = userEntity.getIsActive();
	}

}
