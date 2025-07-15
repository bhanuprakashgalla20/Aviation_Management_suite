package com.aviationmanagementsuite.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CrewForFlight
{
	private String flightNumber;
	@Id
	private String employeeId;  
}
