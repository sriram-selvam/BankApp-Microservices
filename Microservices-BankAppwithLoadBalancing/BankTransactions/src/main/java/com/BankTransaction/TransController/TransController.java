package com.BankTransaction.TransController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BankTransaction.TransEntity.ResponseTransEntity;
import com.BankTransaction.TransService.TransService;

@RestController
@RequestMapping("/Transaction")
public class TransController {

	@Autowired
	private TransService transService;
	
	@GetMapping("/TransacionByCustomer/{Accnum}")
	
	public List<ResponseTransEntity> getTransDetails(@PathVariable("Accnum") String Accnum)
	{
//	Api used	http://localhost:8082/Transaction/TransacionByCustomer/ACC005
		List<ResponseTransEntity> response= transService.getTransDetails(Accnum);
		
		
		
		return response;
	}
	
	@PostMapping("/Transactions/{type}/{amount}/{accNum}")
	public String transactionImpl(@PathVariable("type") String type, @PathVariable("amount") int amount, @PathVariable("accNum") String accNum) {
    String msg=transService.transServiceImpl(type, amount, accNum);
		
		
		
		return msg;
	}

	
	
	
	
}
