package com.aviationmanagementsuite.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aviationmanagementsuite.Entity.FlightEntity;
import com.aviationmanagementsuite.repository.FlightRepository;
@Component
public class FlightDAO 
{
	@Autowired
	FlightRepository flightRepository;
	
	public List<FlightEntity> viewAllFlights() 
	{
		// TODO Auto-generated method stub
		List<FlightEntity> allflights = flightRepository.findAll();
		return allflights;
	}
	public void addFlight(FlightEntity flight) 
	{
		flightRepository.save(flight);
	}
	public FlightEntity selectFlightByUsingID(int flightid) 
	{
		// TODO Auto-generated method stub
		return flightRepository.findByFlightid(flightid);

	}
	public List<FlightEntity> searchFlightsForBook(String origin ,String destination) 
	{
		// TODO Auto-generated method stub
		return flightRepository.findByOriginAndDestination(origin, destination);
	}
	public FlightEntity selectFlightByUsingFlightNumber(String flightnumber) 
	{
		// TODO Auto-generated method stub
		return flightRepository.findByFlightnumber(flightnumber);
	}
}
