package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Integer customerId;
	private String name;
	private String mobileNo;
	private String password;
	private String email;
	public String getMobileNo() {
		// TODO Auto-generated method stub
		return null;
	}
	public Integer getCustomerId() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}