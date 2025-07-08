package com.example.demo.service.dto;

import java.time.LocalDateTime;

public class ContactsDto {
	
	private Long id;
	private String lastName;
	private String firstName;
	private String contactType;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	
	public ContactsDto(Long id, String lastName, String firstName, String contactType, LocalDateTime createdAt, LocalDateTime updatedAt) {
		
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.contactType = contactType;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		
	}
	
	public Long getId() {
		
		return id;
		
	}
	
	public void setId(Long id) {
		
		this.id = id;
		
	}
	
	public String getLastName() {
		
		return lastName;
		
	}
	
	public void setLastName(String lastName) {
		
		this.lastName = lastName;
		
	}
	
	public String getFirstName() {
		
		return firstName;
		
	}
	
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
		
	}
	
	public String getContactType() {
		
		return contactType;
	}
	
	public void setContactType(String contactType) {
		
		this.contactType = contactType;
	}
	
	public LocalDateTime getCreatedAt() {
		
		return createdAt;
		
	}
	
	public void setCreatedAt(LocalDateTime createdAt) {
		
		this.createdAt = createdAt;
		
	}
	
	public LocalDateTime getUpdatedAt() {
		
		return updatedAt;
		
	}
	
	public void setUpdatedAt(LocalDateTime updatedAt) {
		
		this.updatedAt = updatedAt;
	}

}
