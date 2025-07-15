package com.aviationmanagementsuite.Entity;

import java.sql.Time;

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
public class CruwMemberEntity 
{
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;                 // Full Name
	    private String employeeId;           // Unique Crew ID
	    private String role;                 // Pilot, Co-Pilot, Cabin Crew, Ground Staff
	    private String assignedFlightNumber; // Flight this crew is assigned to
	    private String qualification;        // Type of license or qualification
	    private int experienceYears;         // Years of service
	    private String contactNumber;        // Phone
	    private String email;                // Email
	    private String baseAirport;          // Primary Airport base (e.g., DEL, BOM)
	    private String nationality;          // Nationality
	    private String gender;               // Male, Female, Other
	    private String status; 				// Active, On Leave, Retired
	    private Time dutyfrom;
	    private Time dutyto;
}
