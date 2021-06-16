package br.com.scottpilgrim.nanosense;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.scottpilgrim.nanosense.data.converter.SensorDataToVOConverter;
import br.com.scottpilgrim.nanosense.data.converter.VOToSensorDataConverter;


@Configuration
public class RestConfig implements WebMvcConfigurer {

	//adding custom converters
	@Override
	public void addFormatters(FormatterRegistry registry) {
	    registry.addConverter(new SensorDataToVOConverter());
	    registry.addConverter(new VOToSensorDataConverter());
	}
}