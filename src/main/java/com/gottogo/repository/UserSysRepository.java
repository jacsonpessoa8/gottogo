package com.gottogo.repository;

import org.springframework.data.repository.CrudRepository;

import com.gottogo.model.UserSys;

public interface UserSysRepository extends CrudRepository<UserSys, String> {
	UserSys findByusername(String username);
}
