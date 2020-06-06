package com.assignment.spring;

import com.assignment.spring.dto.WeatherResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("acc")
public class ApplicationTests {

	@LocalServerPort
	private int port=8089;
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	@Test
	public void testCreateStudent() throws Exception {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<WeatherResponse> response = restTemplate.exchange(
				createURLWithPort("/weather?city=Amsterdam&appid=342342"), HttpMethod.GET, entity, WeatherResponse.class);
		String actual = response.getBody().toString();
		System.out.println(actual);
		assertTrue(actual.contains("/students"));
	}
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	@Test
	public void contextLoads() {
	}

}
