package com.aviationmanagementsuite.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerNotFoundException extends RuntimeException
{
	private String exceptionmsg;
}
