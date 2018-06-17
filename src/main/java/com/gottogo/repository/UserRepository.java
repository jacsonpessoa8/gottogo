package com.gottogo.repository;

import org.springframework.data.repository.CrudRepository;

import com.gottogo.model.User;

public interface UserRepository extends CrudRepository<User, String> {
	
}
