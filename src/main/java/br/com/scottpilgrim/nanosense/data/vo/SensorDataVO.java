package br.com.scottpilgrim.nanosense.data.vo;

import java.io.Serializable;

public class SensorDataVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	long id;
	long timestamp;
	double value;
	
	public SensorDataVO() {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	

	@Override
	public String toString() {
		return "SensorDataVO [id=" + id + ", timestamp=" + timestamp + ", value=" + value + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
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
		SensorDataVO other = (SensorDataVO) obj;
		if (id != other.id)
			return false;
		if (timestamp != other.timestamp)
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}

	
	
	
}
