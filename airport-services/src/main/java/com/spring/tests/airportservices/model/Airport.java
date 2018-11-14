package com.spring.tests.airportservices.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "airport")
public class Airport implements Serializable {

	public enum DSTCode {
		E, // Europe
		A, // US/Canada
		S, // South America
		O, // Autralia
		Z, // New Zealand
		N, // None
		U // Unknown
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;

	private String name;

	private String city;

	private String country;

	@Column(name = "iatacode")
	private String iataCode;

	@Column(name = "icaocode")

	private String icaoCode;

	private double latitude;

	private double longitude;

	private double altitude;

	@Column(name = "offsetutc")
	private double offsetFromUTC;

	@Column(name = "dstcode")

	@Enumerated(EnumType.STRING)
	private DSTCode dstCode;

	private String timezone;

	public Airport() {
		// default empty constructor
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	public String getIcaoCode() {
		return icaoCode;
	}

	public void setIcaoCode(String icaoCode) {
		this.icaoCode = icaoCode;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public double getOffsetFromUTC() {
		return offsetFromUTC;
	}

	public void setOffsetFromUTC(double offsetFromUTC) {
		this.offsetFromUTC = offsetFromUTC;
	}

	public DSTCode getDstCode() {
		return dstCode;
	}

	public void setDstCode(DSTCode dstCode) {
		this.dstCode = dstCode;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airport other = (Airport) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
