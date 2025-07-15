package com.aviationmanagementsuite.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aviationmanagementsuite.Entity.AdminDetails;
import com.aviationmanagementsuite.repository.AdminRepository;
@Component
public class AdminDAO 
{
	@Autowired
	AdminRepository adminRepository;
	public AdminDetails adminLogin(String empid,String empemailid,String password) {
		// TODO Auto-generated method stub
		return adminRepository.findByEmpidAndEmpemailidAndPassword(empid, empemailid, password);
	}
}
