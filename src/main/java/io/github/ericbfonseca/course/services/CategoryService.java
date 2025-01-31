package io.github.ericbfonseca.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.ericbfonseca.course.entities.Category;
import io.github.ericbfonseca.course.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	// Injetando a dependência de CategoryRepository
	@Autowired
	private CategoryRepository repository;
	
	// Buscar todos os usuários
	public List<Category> findAll( ){
		return repository.findAll();
	}
	// Buscar usuário por Id
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}

}
