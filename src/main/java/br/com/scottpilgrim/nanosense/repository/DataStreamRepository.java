package br.com.scottpilgrim.nanosense.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.scottpilgrim.nanosense.model.DataStream;

public interface DataStreamRepository extends JpaRepository<DataStream, Long> {
	Optional<DataStream> findByKey(String key);
}
