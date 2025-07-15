package com.aviationmanagementsuite.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aviationmanagementsuite.Entity.PassengerEntity;
import com.aviationmanagementsuite.repository.PassengerRepository;

@Component
public class PassengerDAO 
{
	@Autowired
	PassengerRepository passengerRepository;
	public PassengerEntity userLogin(String email,String password) 
	{
		// TODO Auto-generated method stub
		return passengerRepository.findByEmailAndPassword(email, password);
	}
	public boolean userEmailCheck(String email) 
	{
		// TODO Auto-generated method stub
		PassengerEntity byEmail = passengerRepository.findByEmail(email);
		if(byEmail!=null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public void userRegistration(PassengerEntity passengerEntity) 
	{
		// TODO Auto-generated method stub
		passengerRepository.save(passengerEntity);
	}
	
	public PassengerEntity passengerDetailsusingEmail(String email) {
		// TODO Auto-generated method stub
		return passengerRepository.findByEmail(email);
	}
}
