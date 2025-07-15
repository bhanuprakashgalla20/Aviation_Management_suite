package com.aviationmanagementsuite.Entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PassengerEntity 
{
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	    private String name;              // Full Name
	    private String email;             // Email Address
	    private String phonenumber;       // Mobile Number
	    private String passportnumber;    // Passport (for international travel)
	    private String nationality;       // Country of citizenship
	    private String gender;            // Male/Female/Other
	    private Date dateofbirth;       // Date of Birth
//	    private String seatPreference;    // Aisle, Window, Middle
//	    private String mealPreference;    // Veg, Non-Veg, Vegan, etc.
//		private boolean checkedIn;        // Check-in status
//	    private String bookingReference;  // Unique booking code (PNR)
	    private String password;
}
