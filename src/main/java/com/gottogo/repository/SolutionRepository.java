package com.gottogo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gottogo.model.Language;
import com.gottogo.model.Solution;

public interface SolutionRepository extends CrudRepository<Solution, Long> {
	
	Solution findById(long id);
	List<Solution> findByLanguage(Language lang);
}
