package br.com.scottpilgrim.nanosense.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.scottpilgrim.nanosense.model.DataStream;
import br.com.scottpilgrim.nanosense.model.MeasurementUnit;


public class SensorDataExplicitDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private LocalDateTime timestamp;
	private double value;
	@JsonIgnore
	MeasurementUnit measurementUnit;
	long unitId;
	@JsonIgnore
	DataStream ownerStream;
	
	public SensorDataExplicitDTO() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public long getTimestamp() {
		return timestamp.toEpochSecond(ZoneOffset.UTC);
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = LocalDateTime.ofEpochSecond(timestamp, 0, ZoneOffset.UTC);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public MeasurementUnit getMeasurementUnit() {
		return measurementUnit;
	}

	public void setMeasurementUnit(MeasurementUnit measurementUnit) {
		this.measurementUnit = measurementUnit;
	}

	public long getUnitId() {
		return unitId;
	}

	public void setUnitId(long unitId) {
		this.unitId = unitId;
	}

	public DataStream getOwnerStream() {
		return ownerStream;
	}

	public void setOwnerStream(DataStream ownerStream) {
		this.ownerStream = ownerStream;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((measurementUnit == null) ? 0 : measurementUnit.hashCode());
		result = prime * result + ((ownerStream == null) ? 0 : ownerStream.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + (int) (unitId ^ (unitId >>> 32));
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SensorDataExplicitDTO other = (SensorDataExplicitDTO) obj;
		if (id != other.id)
			return false;
		if (measurementUnit == null) {
			if (other.measurementUnit != null)
				return false;
		} else if (!measurementUnit.equals(other.measurementUnit))
			return false;
		if (ownerStream == null) {
			if (other.ownerStream != null)
				return false;
		} else if (!ownerStream.equals(other.ownerStream))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (unitId != other.unitId)
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}
	
	
}