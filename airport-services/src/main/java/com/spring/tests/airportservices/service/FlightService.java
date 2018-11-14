package com.spring.tests.airportservices.service;

import java.util.List;

import com.spring.tests.airportservices.model.Airport;

public interface FlightService {
	
	List<Airport> airportsByCity(String city);
	List<Airport> airportsByCountry(String country);
	Airport airportByIataCode(String iataCode);

}
