package com.BankAccountDetails.AccController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BankAccountDetails.AccEntitiy.ResponseAccEntity;
import com.BankAccountDetails.AccService.AccService;

@RestController
@RequestMapping("/Accounts")
public class AccountController {
	
@Autowired
private AccService accService;

@GetMapping("/AllAccounts")	
public List<ResponseAccEntity> getAlAccounts()
{
	
	
	List<ResponseAccEntity> rs= accService.getAllAccounts();
	return rs;
}
	
@GetMapping("Account/{accNum}")
public ResponseAccEntity getAccountByNumber(@PathVariable("accNum") String num)
{
	ResponseAccEntity accdet=accService.getAccountByAccountNum(num);
	return accdet;
}
@PostMapping("Transactions/{type}/{amount}/{accNum}")
public String transactionImpl(@PathVariable("type") String type, @PathVariable("amount") int amount, @PathVariable("accNum") String accNum) {
	
	String cc= accService.transactionImpl(type, amount, accNum);
	
		return cc;
	}
}
