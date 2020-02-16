package com.esh.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * http://<ip:port>/users/status/
 * IP port information can be obtained from Eureka dashboard: http://localhost:8010, by clicking on USers microservice
 */
@Controller
@RequestMapping("/users")
public class UserRestController {
	@GetMapping(path="/status")
	public ResponseEntity<String> getStatus() {
		return new ResponseEntity<String>("User service online", HttpStatus.OK);
	}

}
