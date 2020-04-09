package com.esh.ex;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventListenerEx {
	
	@EventListener
	public void handleEvent(ApplicationStartedEvent event) {
		System.out.println("EventListenerEx The application got started at" + event.getTimestamp());
	}

}
