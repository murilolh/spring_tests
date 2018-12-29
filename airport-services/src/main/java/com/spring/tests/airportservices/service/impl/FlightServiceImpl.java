package com.spring.tests.airportservices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.tests.airportservices.dao.AirportDao;
import com.spring.tests.airportservices.model.Airport;
import com.spring.tests.airportservices.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private AirportDao airportDAO;

	@Override
	public List<Airport> airportsByCity(String city) {
		return airportDAO.findByCityIgnoreCase(city);
	}

	@Override
	public List<Airport> airportsByCountry(String country) {
		return airportDAO.findByCountryIgnoreCase(country);
	}

	@Override
	public Airport airportByIataCode(String iataCode) {
		return airportDAO.findByIataCodeIgnoreCase(iataCode);
	}

}
