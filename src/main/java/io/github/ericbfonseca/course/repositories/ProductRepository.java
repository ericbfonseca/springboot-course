package io.github.ericbfonseca.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.ericbfonseca.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
