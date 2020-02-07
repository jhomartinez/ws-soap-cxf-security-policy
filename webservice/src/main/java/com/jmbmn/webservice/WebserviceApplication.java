package com.jmbmn.webservice;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.apache.cxf.ws.security.SecurityConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import com.jmbmn.webservice.util.TokenValidator;
import com.jmbmn.webservice.ws.impl.CardWSImpl;

@SpringBootApplication
//@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
public class WebserviceApplication extends SpringBootServletInitializer {	

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(WebserviceApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(WebserviceApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean serveletSoap() {
		ServletRegistrationBean servletSoap = new ServletRegistrationBean(new CXFServlet(), "/CheckOutWSWeb/*");
		servletSoap.setLoadOnStartup(1);
		return servletSoap;
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}

	@Bean
	public Endpoint endpoint() {
		EndpointImpl cxfEndPoint = new EndpointImpl(springBus(), new CardWSImpl());
		cxfEndPoint.publish("/CheckOutWSService");
		cxfEndPoint.getProperties().put(SecurityConstants.USERNAME_TOKEN_VALIDATOR, new TokenValidator());
		return cxfEndPoint;
	}

}
