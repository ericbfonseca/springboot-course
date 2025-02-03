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
	
	// Deleção de usuário
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	// Atualizar usuario
	public User updateUser(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
