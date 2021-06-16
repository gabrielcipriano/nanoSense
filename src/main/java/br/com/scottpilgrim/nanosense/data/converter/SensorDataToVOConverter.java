package br.com.scottpilgrim.nanosense.data.converter;


import java.time.ZoneOffset;

import org.springframework.core.convert.converter.Converter;

import br.com.scottpilgrim.nanosense.data.model.SensorData;
import br.com.scottpilgrim.nanosense.data.vo.SensorDataVO;

public class SensorDataToVOConverter implements Converter<SensorData, SensorDataVO>{
	
	@Override
	public SensorDataVO convert(SensorData source) {
		SensorDataVO vo = new SensorDataVO();
		vo.setId(source.getId());
		vo.setTimestamp(source.getTimestamp().toEpochSecond(ZoneOffset.UTC));
		vo.setValue(source.getValue());
		return vo;
	}

}

