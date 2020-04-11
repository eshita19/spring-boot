package com.esh.ex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventListenerEx {
	private Logger logger = LoggerFactory.getLogger(EventListener.class.getName());
	
	@EventListener
	public void handleEvent(ApplicationStartedEvent event) {
		logger.info("Hi All");
		System.out.println("EventListenerEx The application got started at" + event.getTimestamp());
	}

}
