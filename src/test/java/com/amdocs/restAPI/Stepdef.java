package com.amdocs.restAPI;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT,classes = RestApiApplication.class )
public class Stepdef {
	
	String url;
	double result;
	
	@Given("Rest Api {string}")
	public void rest_Api(String serviceUrl) throws IOException {
	    url = serviceUrl;
	}

	@When("I invoke the given rest api")
	public void i_invoke_the_given_rest_api()throws IOException {
	   
			RestTemplate restTemplate = new RestTemplate();
		    result = restTemplate.getForObject(url, Double.class);
			
	
	}

	@Then("the expected sum is {double}")
	public void the_expected_sum_is(Double double1) {
	   assertEquals(double1,result, 0.01 );
	}



}
