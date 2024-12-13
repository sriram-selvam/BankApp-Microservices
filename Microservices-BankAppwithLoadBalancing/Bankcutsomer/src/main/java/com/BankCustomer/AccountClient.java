package com.BankCustomer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name="BANKACCOUNTDETAILS", path="/Accounts")
public interface AccountClient {

	
	@GetMapping("Account/{accNum}")
	public ResponseAccEntity getAccountByNumber(@PathVariable("accNum") String num);

	@PostMapping("Transactions/{type}/{amount}/{accNum}")
	public String transactionImpl(@PathVariable("type") String type, @PathVariable("amount") int amount, @PathVariable("accNum") String accNum);


}
