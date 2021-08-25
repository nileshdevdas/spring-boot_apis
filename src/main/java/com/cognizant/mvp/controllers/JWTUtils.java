package com.cognizant.mvp.controllers;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtils {
	private String mysecret = "thisisaveryveryveryverysecretkey";
	
	/**
	 * generates a token
	 * @param username
	 * @return
	 */
	public String generateJWTToken(String username) {
		return Jwts.builder().setSubject(username).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1800000))
				.signWith(SignatureAlgorithm.HS256, mysecret).compact();
	}

	/**
	 * Validates a token
	 * @param token
	 */
	public void validateJWTToken(String token) {
		Jwts.parser().setSigningKey(mysecret).parseClaimsJws(token);
	}
}
