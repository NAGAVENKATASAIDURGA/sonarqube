package com.sonar.sonarqube.service;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

@Component
public class Service {
	@Autowired
	private RestTemplate restTemplate;
public void createUser(JsonNode body,String token) {
	HttpHeaders header=new HttpHeaders();
	header.setBasicAuth(token);
	MultiValueMap<String,String> formData=new LinkedMultiValueMap<>();
	formData.add("login", body.get("login").asText());
	formData.add("name", body.get("name").asText());
	formData.add("password", body.get("password").asText());
	restTemplate.exchange("http://10.63.34.162:8084/api/users/create", HttpMethod.POST, new HttpEntity<>(formData,header), List.class);
}
}
