package br.com.scottpilgrim.nanosense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.scottpilgrim.nanosense.model.MeasurementUnit;

public interface MeasurementUnitRepository extends JpaRepository<MeasurementUnit, Long> {

}
