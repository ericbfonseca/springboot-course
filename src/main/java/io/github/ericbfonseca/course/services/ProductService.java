package io.github.ericbfonseca.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.ericbfonseca.course.entities.Product;
import io.github.ericbfonseca.course.repositories.ProductRepository;

@Service
public class ProductService {
	
	// Injetando a dependência de ProductRepository
	@Autowired
	private ProductRepository repository;
	
	// Buscar todos os usuários
	public List<Product> findAll( ){
		return repository.findAll();
	}
	// Buscar usuário por Id
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}

}
