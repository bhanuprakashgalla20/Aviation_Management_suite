package com.aviationmanagementsuite.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightNotFoundException extends RuntimeException
{
	String exceptionmsg;
}
