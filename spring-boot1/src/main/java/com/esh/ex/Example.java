package com.esh.ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example {
	@Value(value = "${spring.devtools.remote.secret}")
	private String remoteSecret;
	
	@Autowired
	private EshProps eshProps;

    public String getRemoteSecret() {
		return remoteSecret;
	}

	public void setRemoteSecret(String remoteSecret) {
		this.remoteSecret = remoteSecret;
	}

	public EshProps getEshProps() {
		return eshProps;
	}

	public void setEshProps(EshProps eshProps) {
		this.eshProps = eshProps;
	}

	@RequestMapping("/")
    String home() {
        return "Hello World! This is " +  eshProps.getName()  + ". Admin enabled is " + remoteSecret;
    }
}