package com.spring.tests.airportservices.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.tests.airportservices.model.Airport;
import com.spring.tests.airportservices.service.FlightService;

@RestController
@RequestMapping(value = "/country")
public class CountryController {

	private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

	@Autowired
	private FlightService flightService;

	@RequestMapping(value = "/{countryName}", method = RequestMethod.GET)
	public List<Airport> search(@PathVariable String countryName) {
		List<Airport> retval = flightService.airportsByCountry(countryName);
		if (retval != null) {
			logger.info("Aiports on contry {}: {}", countryName, retval.size());
		} else {
			logger.info("Aiports on contry {}: 0", countryName);
		}
		return retval;
	}

}
