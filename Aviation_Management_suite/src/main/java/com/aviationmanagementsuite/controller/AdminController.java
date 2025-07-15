package com.aviationmanagementsuite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aviationmanagementsuite.Entity.AdminDetails;
import com.aviationmanagementsuite.Exception.AviationManagementSuiteException;
import com.aviationmanagementsuite.service.AdminService;

@Controller
public class AdminController 
{
	@Autowired
	AdminService adminService;
	@RequestMapping("/adminloginpage")
	public String adminLoginPage() 
	{
		return"/AdminLogin";
	}
	@RequestMapping("/adminlogin")
	public String adminLogin(@RequestParam("empid") String empid,@RequestParam("empemailid") String empemailid,@RequestParam("password") String password,Model model) 
	{
		System.out.println(empid+""+empemailid+""+password);
		// TODO Auto-generated method stub
		AdminDetails adminLogin = adminService.adminLogin(empid, empemailid, password);
		if(adminLogin!=null)
		{
			return "AdminOperations";
		}
		else
		{
			throw new AviationManagementSuiteException("Inncorrect data Plese enter Correct data");
		}
	}
}
