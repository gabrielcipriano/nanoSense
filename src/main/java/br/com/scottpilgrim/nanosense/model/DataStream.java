package br.com.scottpilgrim.nanosense.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

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

import com.fasterxml.jackson.annotation.JsonIgnore;


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
	
	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "measurement_unit_id", nullable = false)
	MeasurementUnit measurementUnit;
	
	private long unitId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="owner_device_id", nullable = false)
	private SensorDevice ownerDevice;
	
	private long deviceId;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ownerStream", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<SensorData> measurements;
	
	@Column(nullable = false)
	private long measurementCount;
	
	
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
		this.unitId = this.measurementUnit.getId();
	}
	
	public long getUnitId() {
		return unitId;
	}

	public void setUnitId(long unitId) {
		this.unitId = unitId;
	}
	

	
	public List<SensorData> getMeasurements() {
		return measurements;
	}

	public void setMeasurements(List<SensorData> measurements) {
		this.measurements = measurements;
	}

	public long getMeasurementCount() {
		return measurementCount;
	}

	public void setMeasurementCount(long measurementCount) {
		this.measurementCount = measurementCount;
	}
	
	public void incrementMeasurementCount() {
		this.measurementCount += 1;
	}



	public SensorDevice getOwnerDevice() {
		return ownerDevice;
	}



	public void setOwnerDevice(SensorDevice ownerDevice) {
		this.ownerDevice = ownerDevice;
		this.deviceId = this.ownerDevice.getId();
	}
	


	public long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (deviceId ^ (deviceId >>> 32));
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + (int) (measurementCount ^ (measurementCount >>> 32));
		result = prime * result + ((measurementUnit == null) ? 0 : measurementUnit.hashCode());
		result = prime * result + ((measurements == null) ? 0 : measurements.hashCode());
		result = prime * result + ((ownerDevice == null) ? 0 : ownerDevice.hashCode());
		result = prime * result + (int) (unitId ^ (unitId >>> 32));
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
		if (deviceId != other.deviceId)
			return false;
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
		if (measurementCount != other.measurementCount)
			return false;
		if (measurementUnit == null) {
			if (other.measurementUnit != null)
				return false;
		} else if (!measurementUnit.equals(other.measurementUnit))
			return false;
		if (measurements == null) {
			if (other.measurements != null)
				return false;
		} else if (!measurements.equals(other.measurements))
			return false;
		if (ownerDevice == null) {
			if (other.ownerDevice != null)
				return false;
		} else if (!ownerDevice.equals(other.ownerDevice))
			return false;
		if (unitId != other.unitId)
			return false;
		return true;
	}
	
	
	
}
