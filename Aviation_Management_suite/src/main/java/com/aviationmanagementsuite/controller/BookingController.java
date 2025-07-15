package com.aviationmanagementsuite.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aviationmanagementsuite.Entity.BookingDetails;
import com.aviationmanagementsuite.Entity.FlightEntity;
import com.aviationmanagementsuite.Entity.PassengerEntity;
import com.aviationmanagementsuite.Exception.BookingDateException;
import com.aviationmanagementsuite.service.BookingService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BookingController 
{
	@Autowired
	BookingService bookingService;
	@Autowired
	FlightController flightController;
	@Autowired
	PassengerController passengerController;
	@RequestMapping("/bookflight")
	public String bookFlight(@RequestParam("flightnumber") String flightnumber,@RequestParam("passengerid") long passengerid,@RequestParam("economyrate") double economyrate,@RequestParam("bussinesrate") double bussinesrate,Model model) 
	{
		// TODO Auto-generated method stub
		model.addAttribute("flightnumber",flightnumber);
		model.addAttribute("passengerid",passengerid);
		model.addAttribute("bookingdate",LocalDate.now());
		return "UserRequirementinFlight";
	}
	
	private int seatNo() 
	{
		Random random = new Random();
		int seatno = random.nextInt(50);
		return seatno;
	}
	private String bookingRefesence(String flightnumber,long passengerid,int seatno,LocalDate bookeddate)
	{
		return passengerid+""+flightnumber+""+seatno+bookeddate;
	}
	@RequestMapping("userrequirementforbooking")
	public String userRequiremtToBookFlight(BookingDetails bookingDetails,Model model,HttpSession httpSession)
	{
		
		bookingDetails.setBookingdate(LocalDate.now());
		// TODO Auto-generated method stub
		httpSession.setAttribute("bookingDetails", bookingDetails);
		if(bookingDetails.getBookingdate().isBefore(bookingDetails.getBookeddate()))
		{
			int seatNo=0;
			while(true)
			{
				seatNo = seatNo();
				if(bookingService.selectSeatNoUsing(seatNo,bookingDetails.getFlightnumber(),bookingDetails.getBookeddate()))
				{
					bookingDetails.setSeatno(seatNo);
					break;
				}	
			}
			FlightEntity flightEntity = flightController.findFlightByFlightnumber(bookingDetails.getFlightnumber());
			String bookingRefesence = bookingRefesence(bookingDetails.getFlightnumber(),bookingDetails.getPassengerid(),bookingDetails.getSeatno(),bookingDetails.getBookeddate());
			bookingDetails.setStatus("Booked");
			bookingDetails.setFlightarrivaltime(flightEntity.getJournyendtime());
			System.out.println(flightEntity.getJournyendtime());
			System.out.println(bookingDetails.getFlightarrivaltime());
			httpSession.setAttribute("bookingDetails", bookingDetails);
			bookingDetails.setBookingreference(bookingRefesence);
			model.addAttribute("bookingDetails",bookingDetails);
			return "PaymentMethod";
		}
		else
		{
			throw new BookingDateException("select date Correctly");
		}
	}
	@RequestMapping("/bookingconform")
	public String bookingConform(BookingDetails bd, Model model,HttpSession httpSession) 
	{
//		BookingDetails bookingDetails = (BookingDetails) httpSession.getAttribute("bookingDetails");
		System.out.println(bd);
//		// TODO Auto-generated method stub
		bookingService.saveBookingDetails(bd);
//		model.addAttribute("bookingDetails",bookingDetails);
		// TODO Auto-generated method stub
				List<BookingDetails> bookingDetails = bookingService.bookingDetailsUsingPassengerId(bd.getPassengerid());
				PassengerEntity passengerEntity = (PassengerEntity) httpSession.getAttribute("passenger");
				System.out.println("session obkect"+passengerEntity);
				model.addAttribute("passenger",passengerEntity);
				model.addAttribute("bookingDetails",bookingDetails);
				return "BokkedTicket";
	}
	@RequestMapping("/bookedticket")
	public String bookedTicket(@RequestParam("id") long passengerid,Model model,HttpSession httpSession) 
	{
		// TODO Auto-generated method stub
		List<BookingDetails> bookingDetails = bookingService.bookingDetailsUsingPassengerId(passengerid);
		PassengerEntity passengerEntity = (PassengerEntity) httpSession.getAttribute("passenger");
		System.out.println(passengerEntity);
		model.addAttribute("passenger",passengerEntity);
		model.addAttribute("bookingDetails",bookingDetails);
		return "BokkedTicket";
	}
	//@ResponseBody
	@RequestMapping("/cancelticket")
	public String cancleFlightTicket(@RequestParam("bid") long bookingid,@RequestParam("pemail") String email,Model model,HttpSession httpSession) 
	{
		System.out.println(bookingid);
		boolean cancleTicket = bookingService.cancleTicket(bookingid);
		PassengerEntity passengerEntity = passengerController.passengerDetailsUsingEmail(email);
		String cancledmsg="Ticket Canclled succsessfully ";
		model.addAttribute("passenger", passengerEntity);
		model.addAttribute("cancledmsg",cancledmsg);
		if (cancleTicket) {
			
			return "UserHome";
		} else {
			
			return "Not";

		}
		// TODO Auto-generated method stub
//		BookingDetails bookingDetails = bookingService.cancleTicket(bookingid);
//		PassengerEntity passengerEntity = (PassengerEntity) httpSession.getAttribute("passenger");
//		System.out.println("passenger details is"+passengerEntity);
//		bookingDetails.setStatus("Cancel");
//		bookingService.saveBookingDetails(bookingDetails);
//		String cancledmsg="Ticket Canclled succsessfully ";
//		model.addAttribute("passenger",passengerEntity);
//		model.addAttribute("cancledmsg",cancledmsg);
//		System.out.println(cancledmsg);
//		return "UserHome";
	}
}
