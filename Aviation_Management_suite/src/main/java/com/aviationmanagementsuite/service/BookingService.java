package com.aviationmanagementsuite.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.aviationmanagementsuite.DAO.BookingDAO;
import com.aviationmanagementsuite.Entity.BookingDetails;

@Service
public class BookingService 
{
	@Autowired
	BookingDAO bookingDAO;
	public boolean selectSeatNoUsing(int seatno,String flightnumber,LocalDate bookeddate) 
	{
		// TODO Auto-generated method stub
		return bookingDAO.selectSeatUsingSeatno(seatno, flightnumber, bookeddate);
	}
	
	public void saveBookingDetails(BookingDetails bookingDetails) 
	{
		// TODO Auto-generated method stub
		bookingDAO.saveBookingDetails(bookingDetails);
	}
	public List<BookingDetails> bookingDetailsUsingPassengerId(long passengerid)
	{
		// TODO Auto-generated method stub
	List<BookingDetails> bookingDetailsList = bookingDAO.bookingDetailsUsingPassengerId(passengerid);
	return bookingDetailsList;
	}
	public boolean cancleTicket(long bookingid)
	{
		// TODO Auto-generated method stub
		BookingDetails bookingDetails = bookingDAO.bookedTicketByUsingId(bookingid);
		if (bookingDetails!=null) {
			
			bookingDetails.setStatus("Cancle");
			
			bookingDAO.saveBookingDetails(bookingDetails);
			
			return true;
			
		} else {
			
			return false;

		}
	}
}
