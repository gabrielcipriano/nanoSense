package br.com.cipriano.nanosense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cipriano.nanosense.model.MeasurementUnit;

public interface MeasurementUnitRepository extends JpaRepository<MeasurementUnit, Long> {

}
