package com.aviationmanagementsuite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aviationmanagementsuite.Entity.BookingDetails;

import java.time.LocalDate;
import java.util.List;


public interface BookingRepository extends JpaRepository<BookingDetails, Long>
{
	
	BookingDetails findBySeatnoAndFlightnumberAndBookeddate(int seatno,String flightnumber,LocalDate bookeddate);
	List<BookingDetails> findByPassengeridAndStatus(long passengerid,String status);
	List<BookingDetails> findByStatus(String status);
	BookingDetails findByBookingid(long bookingid);
}
