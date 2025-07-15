package com.aviationmanagementsuite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aviationmanagementsuite.DAO.PassengerDAO;
import com.aviationmanagementsuite.Entity.PassengerEntity;
import com.aviationmanagementsuite.Exception.PassengerRegistrationException;

@Component
public class PassengerService 
{
	@Autowired
	PassengerDAO passengerDAO;
	public PassengerEntity passengerLogin(String email,String password) 
	{
		// TODO Auto-generated method stub
		return passengerDAO.userLogin(email, password);
	}
	public boolean passengerEmailCheck(String email) 
	{
		// TODO Auto-generated method stub
		return passengerDAO.userEmailCheck(email);
	}
	public void passengerRegistration(PassengerEntity passengerEntity)
	{
		// TODO Auto-generated method stub
		if(passengerEmailCheck(passengerEntity.getEmail()))
		{
			passengerDAO.userRegistration(passengerEntity);
		}
		else
		{
			throw new PassengerRegistrationException("Email already exist Go for Login or Use another email");
		}

	}
	public PassengerEntity passengerDetailsUsingEmail(String email)
	{
		// TODO Auto-generated method stub
		return passengerDAO.passengerDetailsusingEmail(email);
	}
}
