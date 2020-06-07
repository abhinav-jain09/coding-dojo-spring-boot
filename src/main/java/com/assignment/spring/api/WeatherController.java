package com.assignment.spring.api;

import com.assignment.spring.Constants;
import com.assignment.spring.dto.WeatherResponse;
import com.assignment.spring.entity.Weather;
import com.assignment.spring.services.WeatherDataProcessing;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final RestTemplate restTemplate;

    private final WeatherDataProcessing weatherDataProcessing;


    @GetMapping("/weather")
    @ResponseBody
    public Weather weather(@RequestParam("city") String city) {
        String url = Constants.WEATHER_API_URL.replace("{city}", city).replace("{appid}", Constants.APP_ID);
        ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(url, WeatherResponse.class);
        return weatherDataProcessing.mapWeatherData(response.getBody());
    }
}
