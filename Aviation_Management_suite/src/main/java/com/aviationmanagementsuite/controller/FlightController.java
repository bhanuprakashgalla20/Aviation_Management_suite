package com.aviationmanagementsuite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aviationmanagementsuite.Entity.FlightEntity;
import com.aviationmanagementsuite.Entity.PassengerEntity;
import com.aviationmanagementsuite.Exception.FlightNotFoundException;
import com.aviationmanagementsuite.service.FlightService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FlightController 
{
	@Autowired
	FlightService flightService;
	@Autowired
	PassengerController passengerController;
   // @ResponseBody
	@RequestMapping("/flightinfo")
	public String flight() {
		// TODO Auto-generated method stub
		return "/AddFlight";
	}
	
	@RequestMapping("/addflight")
	public String addFight(FlightEntity flightEntity) 
	{
		// TODO Auto-generated method stub
		flightService.addFlight(flightEntity);
		return "forward:/allflights";
	}
	@RequestMapping("/allflights")
	public String allFlightsDetails(Model model) 
	{
		// TODO Auto-generated method stub
		List<FlightEntity> allFlights = flightService.selectAllFlights();
		model.addAttribute("flights",allFlights);
		return "/AllFlightsDetails";
	}
	@RequestMapping("/updateflight")
	public String updateFlightDetails(@RequestParam("flightid") int flightid,Model model) 
	{
		System.out.println(flightid);
		FlightEntity flightEntity = flightService.selectFlightByUsingId(flightid);
		System.out.println(flightEntity);
		model.addAttribute("updateflight",flightEntity);
		System.out.println(flightEntity);
		return "/UpdateFlightDetails";
	}
	
	@RequestMapping("/searchflighttobook")
	public String flightPassengerBooking(@RequestParam("origin") String origin,@RequestParam("destination") String destination,@RequestParam("id") String email,Model model,HttpSession httpSession)
	{
		System.out.println(email);
	    httpSession.setAttribute("mail",email);
		List<FlightEntity> flightsForBook = flightService.searchFlightsForBook(origin, destination);
		System.out.println(flightsForBook);
		PassengerEntity passengerDetails = passengerController.passengerDetailsUsingEmail(email);
		if(flightsForBook.size()!=0)
		{
			model.addAttribute("flightsForBook",flightsForBook);
			model.addAttribute("passengerDetails",passengerDetails);
			return "FlightsForBooking";
		}
		else
		{
			throw new FlightNotFoundException("Enter Correct destination");
		}

	}
	
	public FlightEntity findFlightByFlightnumber(String flightnumber) 
	{
		// TODO Auto-generated method stub
		FlightEntity flightEntity = flightService.selectFlightByUsingFlightnumber(flightnumber);
		return flightEntity;
	}
}
