package io.github.ericbfonseca.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.ericbfonseca.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
