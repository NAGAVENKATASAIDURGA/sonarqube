package com.sonar.sonarqube;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.sonar.sonarqube.service.Service;

@RestController
@RequestMapping("/sonar")
public class Controller {
	@Autowired
	private Service service;
@GetMapping("/createUser")
public void createUser(@RequestBody JsonNode body,@RequestHeader(name="Authorization") String token) {
	
	 service.createUser(body, token);
}
}
