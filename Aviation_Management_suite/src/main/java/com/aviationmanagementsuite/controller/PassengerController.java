package com.aviationmanagementsuite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aviationmanagementsuite.Entity.PassengerEntity;
import com.aviationmanagementsuite.Exception.AviationManagementSuiteException;
import com.aviationmanagementsuite.Exception.PassengerNotFoundException;
import com.aviationmanagementsuite.Exception.PassengerRegistrationException;
import com.aviationmanagementsuite.service.AdminService;
import com.aviationmanagementsuite.service.PassengerService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PassengerController
{

    private final AdminService adminService;
	@Autowired
	PassengerService passengerService;

    PassengerController(AdminService adminService) {
        this.adminService = adminService;
    }
	//@ResponseBody
	@RequestMapping("userregistartion")
	public String userRegistrationPage(PassengerEntity passengerEntity,Model model)
	{
		// TODO Auto-generated method stub
		//String rsm="Registration successful....";
		//model.addAttribute("rsm",rsm);
		//return"forward:/userloginpage";
		if(passengerService.passengerEmailCheck(passengerEntity.getEmail()))
		{
			passengerService.passengerRegistration(passengerEntity);
			String rsm="Registration successful....";
			model.addAttribute("rsm",rsm);
			return "UserLoginPage";
		}
		else
		{
			throw new PassengerRegistrationException("Email already exist Go for Login or Use another email");
		}
	}
	
	@RequestMapping("/userregistrationpage")
	public String userRegistartionPage() 
	{
		// TODO Auto-generated method stub
		return "UserRegistration";
	}
	
	@RequestMapping("/userlogin")
	public String userLogin(String email,String password,Model model,HttpSession httpSession)
	{
		// TODO Auto-generated method stub
		PassengerEntity passengerLogin = passengerService.passengerLogin(email, password);
		if(passengerLogin!=null)
		{
			model.addAttribute("passenger",passengerLogin);
			httpSession.setAttribute("passenger", passengerLogin);
			return "UserHome";
		}
		else
		{
			throw new PassengerNotFoundException("User Not found Enter Correct details or register");
		}
	}
	@RequestMapping("/userloginpage")
	public String userLoginPage() 
	{
		return "UserLoginPage";
	}
	
	public PassengerEntity passengerDetailsUsingEmail(String email) 
	{
		// TODO Auto-generated method stub
		return passengerService.passengerDetailsUsingEmail(email);
	}
}
