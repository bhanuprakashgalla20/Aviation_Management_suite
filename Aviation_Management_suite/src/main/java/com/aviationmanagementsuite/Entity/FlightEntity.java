package com.aviationmanagementsuite.Entity;

import java.sql.Time;
import java.time.LocalTime;

import io.micrometer.common.lang.NonNull;
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
public class FlightEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightid;
	private String flightnumber;    
    private String origin;         
    private String destination;     
    private LocalTime journystarttime;   
    private LocalTime journyendtime;     
    private String airline;         
    private String status; 
    private double economyrate;
    private double bussinesrate;
}
