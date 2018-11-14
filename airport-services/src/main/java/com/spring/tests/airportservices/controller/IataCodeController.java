package com.spring.tests.airportservices.controller;

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
@RequestMapping(value = "/iata")
public class IataCodeController {
	private static final Logger logger = LoggerFactory.getLogger(IataCodeController.class);

	@Autowired
	private FlightService flightService;

	@RequestMapping(value = "/{iataCode}", method = RequestMethod.GET)
	public Airport search(@PathVariable String iataCode) {
		Airport retval = flightService.airportByIataCode(iataCode);
		if (retval != null) {
			logger.info("Airport of IATA code {}: {}/{}/{}", iataCode, retval.getName(), retval.getCity(), retval.getCountry());
		} else {
			logger.info("Airport of IATA code {}: 0", iataCode);
		}
		return retval;
	}
}
