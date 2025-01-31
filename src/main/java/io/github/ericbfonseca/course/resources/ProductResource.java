package io.github.ericbfonseca.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.ericbfonseca.course.entities.Product;
import io.github.ericbfonseca.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	// Injeção de dependência para o Service
	@Autowired
	private ProductService service;
	
	// Endpoint para acessar todos os usuários
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	// Endpoint para buscar um usuário pelo Id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
