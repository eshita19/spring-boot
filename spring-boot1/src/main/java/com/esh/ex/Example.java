package com.esh.ex;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example {
	@Value(value = "${spring.devtools.remote.secret}")
	private String remoteSecret;

    @RequestMapping("/")
    String home() {
        return "Hello World! This is Eshita Mathur. Admin enabled is " + remoteSecret;
    }
}