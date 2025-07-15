package com.aviationmanagementsuite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aviationmanagementsuite.DAO.AdminDAO;
import com.aviationmanagementsuite.Entity.AdminDetails;

@Component
public class AdminService
{
	@Autowired
	AdminDAO adminDAO;
	public AdminDetails adminLogin(String empid,String empemailid,String password) 
	{
		System.out.println(empid);
		System.out.println(empemailid);
		System.out.println(password);
		System.out.println("***-----******----****");

		// TODO Auto-generated method stub
		return adminDAO.adminLogin(empid, empemailid, password);
	}
}
