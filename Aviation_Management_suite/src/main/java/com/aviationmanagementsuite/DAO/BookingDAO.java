package com.aviationmanagementsuite.DAO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.aviationmanagementsuite.Entity.BookingDetails;
import com.aviationmanagementsuite.repository.BookingRepository;

@Component
public class BookingDAO 
{
	@Autowired
	BookingRepository bookingRepository;
	public boolean selectSeatUsingSeatno(int seatno,String flightnumber,LocalDate bookeddate)
	{
		// TODO Auto-generated method stub
	
		BookingDetails bySeatno = bookingRepository.findBySeatnoAndFlightnumberAndBookeddate(seatno, flightnumber,bookeddate);
		if(bySeatno==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void saveBookingDetails(BookingDetails bookingDetails) 
	{
		// TODO Auto-generated method stub
		bookingRepository.save(bookingDetails);
	}
	
	public List<BookingDetails> bookingDetailsUsingPassengerId(long passengerid) 
	{
		// TODO Auto-generated method stub
		return bookingRepository.findByPassengeridAndStatus(passengerid, "Booked");
	}
	
	public List<BookingDetails> updateStatusInBooking(String status) 
	{
		// TODO Auto-generated method stub
		return bookingRepository.findByStatus(status);
	}
	public void updateStatus(List<BookingDetails> bookingDetails) 
	{
		// TODO Auto-generated method stub
		bookingRepository.saveAll(bookingDetails);
	}
	@Scheduled(fixedRate = 60000)
	public void updateBookingStatus() 
	{
		LocalDateTime now=LocalDateTime.now();
		List<BookingDetails> listBookingDetails = bookingRepository.findByStatus("Booked");
		if(listBookingDetails.size()!=0)
		{
			for (BookingDetails bookingDetails : listBookingDetails)
			{
				LocalDateTime journyCompleteDateTime=LocalDateTime.of(bookingDetails.getBookeddate(), bookingDetails.getFlightarrivaltime());
				if(journyCompleteDateTime.isBefore(now))
				{
					bookingDetails.setStatus("Completed");
				}
			}
			bookingRepository.saveAll(listBookingDetails);
			
			System.out.println("Updated ticket status at "+now);
		}

	}
	
	public BookingDetails bookedTicketByUsingId(long bookingid) 
	{
		// TODO Auto-generated method stub
		return bookingRepository.findByBookingid(bookingid);
	}
}
