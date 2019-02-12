package com.food.order.app.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AppService {

	public static String getCart(String email, String password) {
		String url = "http://13.233.214.243:8084/cart?email=" + email;
		RestTemplate restTemplate = new RestTemplate();
		//final String cart = restTemplate.getForObject(url, String.class);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		ResponseEntity<String> response = null;
		try {
	        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	        response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
	    }
	    catch (Exception ex) {
	        System.out.println("** Exception: "+ ex.getMessage());
	    }
		return response.getBody();
	}
	
	/*public static void main(String[] args) {
		System.out.println(getCart("sushil.kuma@hcl.com", null));
	}*/

}