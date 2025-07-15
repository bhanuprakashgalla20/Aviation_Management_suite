package com.aviationmanagementsuite.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aviationmanagementsuite.Entity.FlightEntity;

public interface FlightRepository extends JpaRepository<FlightEntity, Integer>
{
	FlightEntity findByFlightid(int flightid);
	FlightEntity findByFlightnumber(String flightnumber);
	List<FlightEntity> findByOriginAndDestination(String origin,String destination);
}
