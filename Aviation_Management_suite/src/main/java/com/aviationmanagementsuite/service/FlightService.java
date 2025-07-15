package com.aviationmanagementsuite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aviationmanagementsuite.DAO.FlightDAO;
import com.aviationmanagementsuite.Entity.FlightEntity;

@Component
public class FlightService 
{
	@Autowired
	FlightDAO flightDAO;
	
	public List<FlightEntity> selectAllFlights()
	{
		// TODO Auto-generated method stub
		return flightDAO.viewAllFlights();
	}
	
	public void addFlight(FlightEntity flight) 
	{
		
		flightDAO.addFlight(flight);
	}
	public FlightEntity selectFlightByUsingId(int flightid) {
		// TODO Auto-generated method stub
		FlightEntity flightEntity = flightDAO.selectFlightByUsingID(flightid);
		return flightEntity;
	}
	public List<FlightEntity> searchFlightsForBook(String origin,String destination)
	{
		// TODO Auto-generated method stub
		return flightDAO.searchFlightsForBook(origin, destination);
	}
	public FlightEntity selectFlightByUsingFlightnumber(String flightnumber) 
	{
		// TODO Auto-generated method stub
		return flightDAO.selectFlightByUsingFlightNumber(flightnumber);
	}
}
