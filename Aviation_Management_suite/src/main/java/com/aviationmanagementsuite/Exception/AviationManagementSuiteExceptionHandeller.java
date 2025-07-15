package com.aviationmanagementsuite.Exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aviationmanagementsuite.Entity.BookingDetails;
import com.aviationmanagementsuite.Entity.PassengerEntity;

import jakarta.servlet.http.HttpSession;

@ControllerAdvice
public class AviationManagementSuiteExceptionHandeller
{
	@ExceptionHandler(AviationManagementSuiteException.class)
	public String genaricException(AviationManagementSuiteException exception,Model model) 
	{
		// TODO Auto-generated method stub
		String exceptionMessage = exception.getExceptionMessage();
		model.addAttribute("exceptionMessage", exceptionMessage);
		return "AdminLogin";
	}
	@ExceptionHandler(PassengerNotFoundException.class)
	public String passengerException(PassengerNotFoundException passengerNotFoundException,Model model) 
	{
		// TODO Auto-generated method stub
		String exceptionmsg = passengerNotFoundException.getExceptionmsg();
		model.addAttribute("exceptionmsg",exceptionmsg);
		return "UserLoginPage";

	}
	@ExceptionHandler(PassengerRegistrationException.class)
	public String passengerEmailException(PassengerRegistrationException passengerRegistrationException,Model model)
	{
		String exceptionmsg = passengerRegistrationException.getExceptionmsg();
		model.addAttribute("exceptionmsg",exceptionmsg);
		return "UserRegistration";
	}
	@ExceptionHandler(FlightNotFoundException.class)
	public String flightBookingException(FlightNotFoundException flightNotFoundException,Model model,HttpSession httpSession) 
	{
		String emailid = (String) httpSession.getAttribute("mail");
		// TODO Auto-generated method stub
		String exceptionmsg = flightNotFoundException.getExceptionmsg();
		model.addAttribute("exceptionmsg",exceptionmsg);
		PassengerEntity passengerEntity = (PassengerEntity) httpSession.getAttribute("passenger");
		model.addAttribute("passenger", passengerEntity);
		return "UserHome";
	}
	@ExceptionHandler(BookingDateException.class)
	public String bookingDateException(BookingDateException bookingDateException,Model model,HttpSession httpSession)
	{
		// TODO Auto-generated method stub
		BookingDetails bookingDetails = (BookingDetails) httpSession.getAttribute("bookingDetails");
		model.addAttribute("flightnumber",bookingDetails.getFlightnumber());
		model.addAttribute("passengerid",bookingDetails.getPassengerid());
		model.addAttribute("bookingdate",bookingDetails.getBookingdate());
		String exceptionmsg = bookingDateException.getExceptionmsg();
		model.addAttribute("exceptionmsg",exceptionmsg);
		return "UserRequirementinFlight";
	}
}
