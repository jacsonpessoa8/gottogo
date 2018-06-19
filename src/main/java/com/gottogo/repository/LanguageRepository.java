package com.gottogo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gottogo.model.Language;

public interface LanguageRepository extends CrudRepository<Language, Long> {
	
	Language findById(long id);
	
	Language findByName(String name);
}
