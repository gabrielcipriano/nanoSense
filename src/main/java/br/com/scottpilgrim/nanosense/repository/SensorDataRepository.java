package br.com.scottpilgrim.nanosense.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.scottpilgrim.nanosense.model.DataStream;
import br.com.scottpilgrim.nanosense.model.SensorData;

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
	List<SensorData> findFirst5ByOwnerStreamOrderByIdDesc(DataStream ownerStream);
}
