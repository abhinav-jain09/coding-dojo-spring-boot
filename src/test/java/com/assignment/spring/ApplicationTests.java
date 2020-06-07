package com.assignment.spring;

import com.assignment.spring.dto.WeatherResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
public class ApplicationTests {

	RestTemplate restTemplate = new RestTemplate();
	//@LocalServerPort
	private int port = 8089;
	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testCreateStudent() throws Exception {
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);


		ResponseEntity<WeatherResponse> response = restTemplate.exchange(
				createURLWithPort("/weather?city=Amsterdam&appid=342342"), HttpMethod.GET, entity, WeatherResponse.class);
		String actual = response.getBody().toString();
		System.out.println("++++++++++++++++++++++++++++++++++++++++" + actual);
		//assertTrue(actual.contains("/students"));
	}
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	@Test
	public void contextLoads() {
	}

}
