package com.BankCustomer.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankCustomer.AccountClient;
import com.BankCustomer.CustomerDetailsResponse;
import com.BankCustomer.ResponseAccEntity;
import com.BankCustomer.CustomerRepository.customerRepo;
import com.BankCustomer.customerEntity.CustomerEntity;



@Service
public class CustomerService {
	
	@Autowired
	private AccountClient accClient;
	
	@Autowired
	private customerRepo cusRepo;
	 
	public List<CustomerDetailsResponse> getAllCustomers()
	{
		
		List<CustomerEntity> custList= cusRepo.findAll();
		List<CustomerDetailsResponse> responseDetails= new ArrayList();
		
		for(CustomerEntity cust: custList)
		{
			CustomerDetailsResponse response = new CustomerDetailsResponse();
			BeanUtils.copyProperties(cust, response);
			responseDetails.add(response);
		}
	
	return responseDetails;
	}

	public CustomerDetailsResponse getCustomerById(String accNum)
	{
		
		CustomerEntity cust=cusRepo.getAccountDetails(accNum);
				
				
		CustomerDetailsResponse response = new CustomerDetailsResponse();
	
			BeanUtils.copyProperties(cust, response);

		
		ResponseAccEntity responseAcc=  accClient.getAccountByNumber(accNum);
		
		response.setAccountResponse(responseAcc);
		
		return response;
	}
	
	public String transactionImpl(String type,int amount,String accNum)
	{
		
//		CustomerEntity cust=cusRepo.getAccountDetails(accNum);
//				
//				
//		CustomerDetailsResponse response = new CustomerDetailsResponse();
//	
//			BeanUtils.copyProperties(cust, response);

		
		String responseAcc=  accClient.transactionImpl(type,amount,accNum);
		return responseAcc;
	}
	

}
