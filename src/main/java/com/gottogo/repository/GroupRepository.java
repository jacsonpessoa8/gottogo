package com.gottogo.repository;

import org.springframework.data.repository.CrudRepository;

import com.gottogo.model.Group;

public interface GroupRepository extends CrudRepository<Group, String> {
	
}

