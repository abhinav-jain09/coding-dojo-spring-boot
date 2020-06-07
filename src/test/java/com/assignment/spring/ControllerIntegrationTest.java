package com.assignment.spring;

import com.assignment.spring.api.WeatherController;
import com.assignment.spring.dto.WeatherResponse;
import com.assignment.spring.entity.Weather;
import com.assignment.spring.repository.WeatherRepository;
import com.assignment.spring.services.WeatherDataProcessing;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = WeatherController.class)
public class ControllerIntegrationTest {

    private MockMvc mvc;
    @Before
    public void setUp() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        WeatherRepository localMockRepository = Mockito.mock(WeatherRepository.class);
        Mockito.when(localMockRepository.save(Mockito.any())).thenReturn( Weather.builder().city("Amsterdam").build());

        WeatherDataProcessing weatherDataProcessing = new WeatherDataProcessing(localMockRepository);

          mvc = MockMvcBuilders.standaloneSetup(new WeatherController(restTemplate,weatherDataProcessing)).build();
        MockitoAnnotations.initMocks(this);
        JacksonTester.initFields(this, new ObjectMapper());
    }
    @Test
    public void getAllEmployeesAPI() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/weather?city={city}", "Amsterdam")
                .accept(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk());

    }
}
