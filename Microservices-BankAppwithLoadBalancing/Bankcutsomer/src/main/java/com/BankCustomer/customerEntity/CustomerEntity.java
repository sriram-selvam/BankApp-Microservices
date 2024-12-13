package com.BankCustomer.customerEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer")
public class CustomerEntity {

	
	 @Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE)
	 @Column(name="id")
	 private int id;
	
	 @Column(name="name")
	private String name;
	
	

	@Column(name="accountnumber")
	private String accountNumber;
	
	 @Column(name="mobilenumber")
	private long mobileNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 public String getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	 
	 
	 
	 
}
