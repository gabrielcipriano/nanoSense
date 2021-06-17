package br.com.scottpilgrim.nanosense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.scottpilgrim.nanosense.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
