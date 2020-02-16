package com.esh.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User Account Service: http://<ip:port>/accounts/status 
 */
@RestController
@RequestMapping("/accounts")
public class UserAccountController {
	
	@GetMapping(path= "/{status}")
	public ResponseEntity<String> getStatus() {
		return new ResponseEntity<String>("Account service is running", HttpStatus.OK); 
	}

}
