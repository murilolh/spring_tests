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
@RequestMapping(value = "/city")
public class CityController {

	private static final Logger logger = LoggerFactory.getLogger(CityController.class);

	@Autowired
	private FlightService flightService;

	@RequestMapping(value = "/{cityName}", method = RequestMethod.GET)
	public List<Airport> search(@PathVariable String cityName) {
		List<Airport> retval = flightService.airportsByCity(cityName);
		if (retval != null) {
			logger.info("Aiports on the city {}: {}", cityName, retval.size());
		} else {
			logger.info("Aiports on the city {}: 0", cityName);
		}
		return retval;
	}

}
