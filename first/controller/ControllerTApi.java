package com.project.first.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.first.service.ServiceTApi;
@RestController
@RequestMapping("/third/api")

public class ControllerTApi {
	
	@Autowired
	private ServiceTApi sa;
	
	
	@GetMapping("/GetAll")
	public List
	{
		return null;
		
	}
	
	
	@GetMapping("/getbyid")
	public ResponseEntity getById(@PathVariable(value="id") Long id,@RequestMapping @Valid ) {
		return null;
		
	}
	
}
