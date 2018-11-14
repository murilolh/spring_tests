package com.spring.tests.airportservices.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.tests.airportservices.model.Airport;

public interface AirportDAO extends JpaRepository<Airport, Long> {

	List<Airport> findByCityIgnoreCase(String city);

	List<Airport> findByCountryIgnoreCase(String country);

	Airport findByIataCodeIgnoreCase(String iataCode);

}
