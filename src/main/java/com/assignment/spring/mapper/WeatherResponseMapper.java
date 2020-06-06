package com.assignment.spring.mapper;

import com.assignment.spring.dto.WeatherResponse;
import com.assignment.spring.entity.Weather;

import java.util.function.Function;

public class WeatherResponseMapper {

    public static final Function<WeatherResponse, Weather> mapper = weatherResponse -> Weather.builder()
            .city(weatherResponse.getName())
            .country(weatherResponse
                    .getSys()
                    .getCountry())
            .temperature(weatherResponse.
                    getMain()
                    .getTemp())
            .build();
}
