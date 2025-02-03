package io.github.ericbfonseca.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.ericbfonseca.course.entities.User;
import io.github.ericbfonseca.course.repositories.UserRepository;

@Service
public class UserService {
	
	// Injetando a dependência de UserRepository
	@Autowired
	private UserRepository repository;
	
	// Buscar todos os usuários
	public List<User> findAll( ){
		return repository.findAll();
	}
	// Buscar usuário por Id
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	// Salvar usuário
	public User insert(User obj) {
		return repository.save(obj);
	}

}
