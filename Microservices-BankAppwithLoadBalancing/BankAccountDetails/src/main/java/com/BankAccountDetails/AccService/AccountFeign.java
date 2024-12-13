package com.BankAccountDetails.AccService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="BANKTRANSACTIONS", path="/Transaction/")
public interface AccountFeign {
	@PostMapping("/Transactions/{type}/{amount}/{accNum}")
	public String transactionImpl(@PathVariable("type") String type, @PathVariable("amount") int amount, @PathVariable("accNum") String accNum);

}
