package br.com.scottpilgrim.nanosense.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.scottpilgrim.nanosense.model.MeasurementUnit;
import br.com.scottpilgrim.nanosense.model.SensorData;
import br.com.scottpilgrim.nanosense.model.SensorDevice;

public class DataStreamExplicitDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private long id;
	private String key;
	private String label;
	private boolean enabled;
	
	@JsonIgnore
	MeasurementUnit measurementUnit;
	private long unitId;
	
	@JsonIgnore
	private SensorDevice ownerDevice;
	private long deviceId;
	
	private long measurementCount;
	List<SensorData> measurements;
	
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
	public long getUnitId() {
		return unitId;
	}
	public void setUnitId(long unitId) {
		this.unitId = unitId;
	}
	public SensorDevice getOwnerDevice() {
		return ownerDevice;
	}
	public void setOwnerDevice(SensorDevice ownerDevice) {
		this.ownerDevice = ownerDevice;
	}
	public long getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
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
		DataStreamExplicitDTO other = (DataStreamExplicitDTO) obj;
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
