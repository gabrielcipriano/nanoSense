package br.com.cipriano.nanosense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cipriano.nanosense.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
