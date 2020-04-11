package com.esh.ex;

import javax.servlet.ServletContextListener;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.esh.servlets.MyFilter;
import com.esh.servlets.MyServlet;
import com.esh.servlets.MyServletContextListener;

@Configuration
public class SpringBootConfig {
	
	// Register Servlet
	  @Bean
	  public ServletRegistrationBean servletRegistrationBean() {
	    ServletRegistrationBean bean = new ServletRegistrationBean(
	        new MyServlet(), "/myServlet"); // http://localhost:8080/myServlet
	    return bean;
	  }

	  // Register Filter
	  @Bean
	  public FilterRegistrationBean filterRegistrationBean() {
	    FilterRegistrationBean bean = new FilterRegistrationBean(new MyFilter());
	    // Mapping filter to a Servlet
	    bean.addServletRegistrationBeans(new ServletRegistrationBean[] {
	          servletRegistrationBean() 
	       });
	    return bean;
	  }

	  // Register ServletContextListener
	  @Bean
	  public ServletListenerRegistrationBean<ServletContextListener> listenerRegistrationBean() {
	    ServletListenerRegistrationBean<ServletContextListener> bean = 
	        new ServletListenerRegistrationBean<>();
	    bean.setListener(new MyServletContextListener());
	    return bean;

	  }

}
