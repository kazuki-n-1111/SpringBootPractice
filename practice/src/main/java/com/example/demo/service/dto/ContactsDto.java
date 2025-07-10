package com.example.demo.service.dto;

import java.time.LocalDateTime;

public class ContactsDto {
	
	private Long id;
	private String lastName;
	private String firstName;
	private String contactType;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	// 追記
	private String email;
	private String phone;
	private String zipCode;
	private String address;
	private String buildingName;
	private String body;
	
	
	public ContactsDto(Long id, String lastName, String firstName, String contactType, LocalDateTime createdAt, LocalDateTime updatedAt, String email, String phone, String zipCode, String address, String buildingName, String body) {
		
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.contactType = contactType;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		
		// 追記
		this.email = email;
		this.phone = phone;
		this.zipCode = zipCode;
		this.address = address;
		this.buildingName = buildingName;
		this.body = body;
		
	}
	
	public ContactsDto(Long id, String lastName, String firstName, String contactType,String email, String phone, String zipCode, String address, String buildingName, String body) {
		
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.contactType = contactType;
		this.email = email;
		this.phone = phone;
		this.zipCode = zipCode;
		this.address = address;
		this.buildingName = buildingName;
		this.body = body;
		
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
	
	// 追記
	
	public String getEmail() {
		
		return email;
	}
	
	public void setEmail(String email) {
		
		this.email = email;
	}
	
	public String getPhone() {
		
		return phone;
	}
	
	public void setPhone(String phone) {
		
		this.phone = phone;
	}
	
	public String getZipCode() {
		
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		
		this.zipCode = zipCode;
	}
	
	public String getAddress() {
		
		return address;
	}
	
	public void setAddress(String address) {
		
		this.address = address;
	}
	
	public String getBuildingName() {
		
		return buildingName;
	}
	
	public void setBuildingName(String buildingName) {
		
		this.buildingName = buildingName;
	}
	
	public String getBody() {
		
		return body;
	}
	
	public void setBody(String body) {
		
		this.body = body;
	}

}
