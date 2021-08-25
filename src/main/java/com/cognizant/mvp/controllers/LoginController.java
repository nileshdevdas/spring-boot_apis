package com.cognizant.mvp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {
	@Autowired
	private JWTUtils jwtUtils;

	@PostMapping
	public LoginReponse login(@RequestBody User user) {
		// here its your responsibility to check if the user exist or not if yes then 
		// only give him the token else .... (Throw him out);
		LoginReponse response = new LoginReponse();
		response.setUsername(user.getUsername());
		response.setToken(jwtUtils.generateJWTToken(user.getUsername()));
		return response;
	}
}
