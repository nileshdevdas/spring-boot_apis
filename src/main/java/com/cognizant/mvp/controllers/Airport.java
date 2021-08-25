package com.cognizant.mvp.controllers;

public class Airport {

	private String airportName;
	private String airportType;

	public Airport() {
	}

	public Airport(String airportName, String airportType) {
		super();
		this.airportName = airportName;
		this.airportType = airportType;
	}

	public String getAirportName() {
		return airportName;
	}

	public String getAirportType() {
		return airportType;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public void setAirportType(String airportType) {
		this.airportType = airportType;
	}
}