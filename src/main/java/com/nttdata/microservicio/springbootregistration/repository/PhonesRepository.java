package com.nttdata.microservicio.springbootregistration.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.microservicio.springbootregistration.entity.PhonesEntity;

@Repository
public interface PhonesRepository extends JpaRepository<PhonesEntity, UUID> {

}
