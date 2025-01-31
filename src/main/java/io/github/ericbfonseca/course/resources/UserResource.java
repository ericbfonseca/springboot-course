package io.github.ericbfonseca.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.ericbfonseca.course.entities.User;
import io.github.ericbfonseca.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	// Injeção de dependência para o Service
	@Autowired
	private UserService service;
	
	// Endpoint para acessar todos os usuários
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	// Endpoint para buscar um usuário pelo Id
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
