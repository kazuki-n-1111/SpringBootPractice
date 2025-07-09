package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ContactDetail;


public interface DetailRepository extends JpaRepository<ContactDetail, Long>{

}
