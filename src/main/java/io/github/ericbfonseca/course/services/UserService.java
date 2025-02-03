package io.github.ericbfonseca.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import io.github.ericbfonseca.course.entities.User;
import io.github.ericbfonseca.course.repositories.UserRepository;
import io.github.ericbfonseca.course.resources.exceptions.DatabaseException;
import io.github.ericbfonseca.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	// Salvar usuário
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	// Deleção de usuário
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	// Atualizar usuario
	public User updateUser(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
