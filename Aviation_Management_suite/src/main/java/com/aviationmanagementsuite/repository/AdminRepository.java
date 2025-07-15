package com.aviationmanagementsuite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aviationmanagementsuite.Entity.AdminDetails;

import java.util.List;


public interface AdminRepository extends JpaRepository<AdminDetails, String>
{
	//@Query("select admin from AdminDetails admin where admin.empid=?1and admin.empemailid=?2and admin.password=?3")
	AdminDetails findByEmpidAndEmpemailidAndPassword(String empid, String empemailid, String password);
}
