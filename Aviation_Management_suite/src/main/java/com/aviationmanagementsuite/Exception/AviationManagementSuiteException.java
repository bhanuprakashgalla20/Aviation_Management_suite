package com.aviationmanagementsuite.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AviationManagementSuiteException extends RuntimeException
{
	private String exceptionMessage;
}
