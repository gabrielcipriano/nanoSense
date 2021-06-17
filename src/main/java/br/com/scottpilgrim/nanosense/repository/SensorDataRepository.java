package br.com.scottpilgrim.nanosense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.scottpilgrim.nanosense.model.SensorData;

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {

}
