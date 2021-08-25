package com.cognizant.mvp.controllers;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class TokenFilter extends OncePerRequestFilter {

	@Autowired
	private JWTUtils jwtUtils;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// here you can decide of the toekn
		// you get you custom token
		String headerValue = request.getHeader("Authorization");
		if (headerValue != null || headerValue.length() != 0) {
			// you rip of the token 
			String token = headerValue.substring("Bearer ".length(), headerValue.length());
			jwtUtils.validateJWTToken(token);
			UsernamePasswordAuthenticationToken springtoken = new UsernamePasswordAuthenticationToken("nilesh",
					"nilesh", Arrays.asList(new SimpleGrantedAuthority("ADMIN")));
			springtoken.setAuthenticated(true);
			SecurityContextHolder.getContext().setAuthentication(springtoken);
		}
	}

}
