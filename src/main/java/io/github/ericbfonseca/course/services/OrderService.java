package io.github.ericbfonseca.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.ericbfonseca.course.entities.Order;
import io.github.ericbfonseca.course.repositories.OrderRepository;

@Service
public class OrderService {
	
	// Injetando a dependência de UserRepository
	@Autowired
	private OrderRepository repository;
	
	// Buscar todos os usuários
	public List<Order> findAll( ){
		return repository.findAll();
	}
	// Buscar usuário por Id
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}

}
