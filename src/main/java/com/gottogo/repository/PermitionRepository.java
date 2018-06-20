package com.gottogo.repository;

import org.springframework.data.repository.CrudRepository;

import com.gottogo.model.Permition;

public interface PermitionRepository extends CrudRepository<Permition, String> {
	Permition findByName(String name);
}
