package com.cognizant.mvp;

import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.github.tomakehurst.wiremock.WireMockServer;

@SpringBootTest
class SpringrestapisApplicationTests {
	WireMockServer server = null;

	@Autowired
	MockMvc mvc;

	@BeforeEach
	public void init() {
		server = new WireMockServer();
		server.start();
	}

	@Test
	void contextLoads() {
		// test here as webserivce....
	}

	@Test
	void testListAirportsApi() throws Exception {
		mvc.perform(get("airport")).andExpect((ResultMatcher) containsStringIgnoringCase("a1"));
	}

	@AfterEach
	public void destroy() {
		server.stop();

	}

}
