package com.BankCustomer;

public class CustomerDetailsResponse {

	
	private int id;
	private String name;
    private String accountNumber;
    private long mobileNumber;
    private ResponseAccEntity AccountResponse;
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
	public ResponseAccEntity getAccountResponse() {
		return AccountResponse;
	}
	public void setAccountResponse(ResponseAccEntity accountResponse) {
		AccountResponse = accountResponse;
	}
	
}

