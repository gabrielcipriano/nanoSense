package br.com.scottpilgrim.nanosense.model;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table
public class SensorData implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(nullable=false)
	private LocalDateTime timestamp;
	
	@Column(nullable=false)
	private double value;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="measurement_unit_id", nullable = false)
	MeasurementUnit measurementUnit;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "data_stream_id", nullable = false)
	DataStream dataStream;
	
	public SensorData() {
		
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
	
	public DataStream getDataStream() {
		return dataStream;
	}

	public void setDataStream(DataStream dataStream) {
		this.dataStream = dataStream;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataStream == null) ? 0 : dataStream.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((measurementUnit == null) ? 0 : measurementUnit.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
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
		SensorData other = (SensorData) obj;
		if (dataStream == null) {
			if (other.dataStream != null)
				return false;
		} else if (!dataStream.equals(other.dataStream))
			return false;
		if (id != other.id)
			return false;
		if (measurementUnit == null) {
			if (other.measurementUnit != null)
				return false;
		} else if (!measurementUnit.equals(other.measurementUnit))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}

	
	//Auto-generated

	

}
