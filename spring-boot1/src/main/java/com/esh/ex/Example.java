package com.esh.ex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example {
	private Logger logger = LoggerFactory.getLogger(EventListener.class.getName());
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
		logger.info("Hi All");
        return "Hello World! This is " +  eshProps.getName()  + ". Admin enabled is " + remoteSecret;
    }
}