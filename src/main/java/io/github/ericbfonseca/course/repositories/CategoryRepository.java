package io.github.ericbfonseca.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.ericbfonseca.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
