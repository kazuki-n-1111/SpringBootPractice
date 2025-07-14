package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Admins;

public interface CertificateRepository extends JpaRepository<Admins, Long> {

	boolean existsByEmail(String email);
	
	boolean existsByPassword(String password);
}
