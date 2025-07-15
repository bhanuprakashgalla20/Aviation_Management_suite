package com.aviationmanagementsuite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aviationmanagementsuite.Entity.PassengerEntity;
import java.util.List;


public interface PassengerRepository extends JpaRepository<PassengerEntity, Long>
{
	PassengerEntity findByEmailAndPassword(String email, String password);
	PassengerEntity findByEmail(String email);
}
