package io.github.ericbfonseca.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.ericbfonseca.course.entities.Order;
import io.github.ericbfonseca.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	// Injeção de dependência para o Service
	@Autowired
	private OrderService service;
	
	// Endpoint para acessar todos os usuários
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	// Endpoint para buscar um usuário pelo Id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
