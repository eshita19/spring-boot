package com.esh.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import com.esh.rest.beans.User;

@Component
@Path(value = "/user")
public class UserRestProvider {
	//http://localhost:8080/esh/user
	@GET
	@Produces("application/xml")
	public  User getUser() {
		User user = new User();
		user.setName("eshita");
		user.setPwd("pwd");
		return user;
	}

}
