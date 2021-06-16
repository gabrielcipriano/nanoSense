package br.com.scottpilgrim.nanosense.data.converter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.core.convert.converter.Converter;

import br.com.scottpilgrim.nanosense.data.model.SensorData;
import br.com.scottpilgrim.nanosense.data.vo.SensorDataVO;

public class VOToSensorDataConverter implements Converter<SensorDataVO, SensorData>{

	@Override
	public SensorData convert(SensorDataVO source) {
		SensorData sensorData = new SensorData();
		sensorData.setId(source.getId());
		sensorData.setTimestamp(LocalDateTime.ofEpochSecond(source.getTimestamp(), 0, ZoneOffset.UTC));
		sensorData.setValue(source.getValue());
		return sensorData;
	}

}
