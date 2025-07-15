package com.aviationmanagementsuite.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookingDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookingid;
	private String flightnumber;  
	private long passengerid;
	private String mealpreference;    // Veg, Non-Veg, Vegan, etc.
    private String bookingreference;
    private String seat;
    private int seatno;
    private LocalDate bookingdate;
    private LocalDate bookeddate;
    private String status;
    private LocalTime flightarrivaltime;
}
