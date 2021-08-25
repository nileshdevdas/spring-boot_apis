package com.cognizant.mvp.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * this method will allow you to decide what is whitelisted and what is not
	 * 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String[] whiteListedURL = { "/", "/login", "swagger-ui" };
		http.cors().and().csrf().disable().authorizeRequests().antMatchers(whiteListedURL).permitAll().anyRequest()
				.authenticated();
		http.addFilter(new TokenFilter());
	}
}
