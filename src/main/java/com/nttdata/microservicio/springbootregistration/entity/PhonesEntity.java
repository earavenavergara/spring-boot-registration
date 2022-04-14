package com.nttdata.microservicio.springbootregistration.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Transactional
@NoArgsConstructor
@Entity
public class PhonesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "phones_id")
	private UUID phonesId;

	private Long number;

	@JsonProperty("citycode")
	private Long cityCode;

	@JsonProperty("contrycode")
	private Long contryCode;

}
