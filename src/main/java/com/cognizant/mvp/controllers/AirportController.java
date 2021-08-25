package com.cognizant.mvp.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// http://host:port/airport
@RestController
@RequestMapping(path = "airport")
public class AirportController {

	@GetMapping
	public List<Airport> listAll() {
		System.out.println("Returning all...");
		return Arrays.asList(new Airport("a", "b"), new Airport("a1", "b"), new Airport("a2", "b"),
				new Airport("a2", "b"));
	}

	@GetMapping(path = "/{airportname}")
	public Airport listSingleAirport(@PathVariable("airportname") String airportName) {
		System.out.println("Returning Single");
		return new Airport("a", "b");
	}

	@GetMapping(path = "/v2/{airportname}")
	public Airport listSingleAirportV2(@PathVariable("airportname") String airportName) {
		System.out.println("Returning Single");
		return new Airport("av2", "bv2");
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public Airport createAirport(@RequestBody Airport airport) {
		System.out.println("Airport Created...");
		return airport;
	}

	@DeleteMapping
	public void deleteAirport(@RequestBody Airport airport) {
		System.out.println("Deleted....");
	}

	@PutMapping(headers = { "secret=someval", "apikey=299292939" })
	public Airport updateAirport(@RequestBody Airport airport) {
		System.out.println("Update....");
		return airport;
	}

	@GetMapping(path = "/sometest")
	public Airport listSingleAirportV2Params(@RequestParam("username") String airportName) {
		System.out.println(airportName);
		return new Airport("av2", "bv2");
	}

	@RequestMapping(path = "*", method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH,
			RequestMethod.PUT })
	public String oops() {
		return "Oops Error Occured no such Url";
	}

}
