package com.assignment.spring.services;
import com.assignment.spring.dto.WeatherResponse;
import com.assignment.spring.entity.Weather;
import com.assignment.spring.mapper.WeatherResponseMapper;
import com.assignment.spring.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherDataProcessing {
@Autowired
    private WeatherRepository weatherRepository;
    public Weather mapWeatherData(WeatherResponse response) {
      Weather entity = WeatherResponseMapper.mapper.apply(response);
        weatherRepository.save(entity);
        return entity;
    }
}
