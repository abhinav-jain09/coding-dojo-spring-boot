package com.assignment.spring.api;

import com.assignment.spring.Constants;
import com.assignment.spring.entity.Weather;
import com.assignment.spring.dto.WeatherResponse;
import com.assignment.spring.services.WeatherDataProcessing;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WeatherController {
@Autowired
    private RestTemplate restTemplate;
@Autowired
    private WeatherDataProcessing weatherDataProcessing;


    @RequestMapping("/weather")
    public Weather weather(HttpServletRequest request) {
        String city = request.getParameter("city");
        String url = Constants.WEATHER_API_URL.replace("{city}", city).replace("{appid}", Constants.APP_ID);
        ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(url, WeatherResponse.class);

        return weatherDataProcessing.mapWeatherData(response.getBody());


    }

}
