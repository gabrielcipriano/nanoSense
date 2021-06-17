package br.com.scottpilgrim.nanosense.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.scottpilgrim.nanosense.model.SensorDevice;

public interface SensorDeviceRepository extends JpaRepository<SensorDevice, Long> {
	Optional<SensorDevice> findByKey(String key);
}
