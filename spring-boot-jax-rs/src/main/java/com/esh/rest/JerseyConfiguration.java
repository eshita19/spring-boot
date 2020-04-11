package com.esh.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfiguration extends ResourceConfig{
	JerseyConfiguration(){
		register(UserRestProvider.class);
	}
}
