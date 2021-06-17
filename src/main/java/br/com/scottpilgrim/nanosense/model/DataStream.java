package br.com.scottpilgrim.nanosense.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table
public class DataStream implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="stream_key", nullable=false, length = 32)
	private String key;
	
	@Column(nullable=false, length = 63)
	private String label;
	
	@Column(nullable=false)
	private boolean enabled;
	
	@Column(nullable = false)
	private AtomicLong measurementCount = new AtomicLong();
	
	@JsonProperty("unitId")
	@ManyToOne(optional = false)
	@JoinColumn(name = "measurement_unit_id", nullable = false)
	MeasurementUnit measurementUnit;
	
	@OneToMany(mappedBy = "dataStream", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<SensorData> sensorDatas;
	
	
	public DataStream() {
		this.key = UUID.randomUUID().toString().replace("-", "");
	}

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public MeasurementUnit getMeasurementUnit() {
		return measurementUnit;
	}

	public void setMeasurementUnit(MeasurementUnit measurementUnit) {
		this.measurementUnit = measurementUnit;
	}

	public List<SensorData> getSensorDatas() {
		return sensorDatas;
	}

	public void setSensorDatas(List<SensorData> sensorDatas) {
		this.sensorDatas = sensorDatas;
	}

	public long getMeasurementCount() {
		return measurementCount.longValue();
	}

	public void setMeasurementCount(long measurementCount) {
		this.measurementCount.set(measurementCount);
	}
	
	public long incrementAndGetMeasurementCount() {
		return measurementCount.incrementAndGet();
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((measurementCount == null) ? 0 : measurementCount.hashCode());
		result = prime * result + ((measurementUnit == null) ? 0 : measurementUnit.hashCode());
		result = prime * result + ((sensorDatas == null) ? 0 : sensorDatas.hashCode());
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
		DataStream other = (DataStream) obj;
		if (enabled != other.enabled)
			return false;
		if (id != other.id)
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (measurementCount == null) {
			if (other.measurementCount != null)
				return false;
		} else if (getMeasurementCount() != other.getMeasurementCount())
			return false;
		if (measurementUnit == null) {
			if (other.measurementUnit != null)
				return false;
		} else if (!measurementUnit.equals(other.measurementUnit))
			return false;
		if (sensorDatas == null) {
			if (other.sensorDatas != null)
				return false;
		} else if (!sensorDatas.equals(other.sensorDatas))
			return false;
		return true;
	}

	
	
	
}
