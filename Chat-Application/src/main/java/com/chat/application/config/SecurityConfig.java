package com.chat.application.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.chat.application.filter.SecurityFilter;

@Configuration
public class SecurityConfig {
	
	
	@Autowired
	SecurityFilter securityFilter;
	
	@Bean
	public FilterRegistrationBean<SecurityFilter>customFilter(){
		
		FilterRegistrationBean <SecurityFilter> registrationBean=new FilterRegistrationBean<>();
		
		registrationBean.setFilter(securityFilter);
		registrationBean.addUrlPatterns("/chatRoom/*");
		registrationBean.setOrder(1);
		return registrationBean;
		
	}
	


	

}
