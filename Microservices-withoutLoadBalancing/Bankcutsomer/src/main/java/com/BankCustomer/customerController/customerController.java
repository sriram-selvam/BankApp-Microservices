package com.BankCustomer.customerController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BankCustomer.CustomerDetailsResponse;
import com.BankCustomer.CustomerService.CustomerService;
import com.BankCustomer.customerEntity.CustomerEntity;

@RestController
@RequestMapping("/customer")
public class customerController {
	
	@Autowired
	private CustomerService custService;

	@GetMapping("/customers")
	public List<CustomerDetailsResponse> getCustomers(){
  //Api used to get this details is http://localhost:8080/customer/customers		
		List<CustomerDetailsResponse> custEntity=custService.getAllCustomers();
		
		return custEntity;
	}
	
	@GetMapping("/customers/{accNum}")
	public CustomerDetailsResponse getCustomerById(@PathVariable("accNum")String accNum){
//	Api Used	http://localhost:8080/customer/customers/ACC004
		CustomerDetailsResponse custEntity=custService.getCustomerById(accNum);
		
		return custEntity;
	}
	
	@PostMapping("/Transactions/{type}/{amount}/{accNum}")
	public String transactionImpl(@PathVariable("type") String type, @PathVariable("amount") int amount, @PathVariable("accNum") String accNum) {
//		http://localhost:8080/customer/Transactions/cr/110/ACC002
	String msg = custService.transactionImpl(type, amount, accNum);
		
		return "Transaction status: Success"+ msg;}
	
	
}
