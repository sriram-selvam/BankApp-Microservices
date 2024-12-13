package com.BankTransaction.TransService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name="feignTrans",url="http://localhost:8081/Accounts/")
public interface TransFeignClient {
	@GetMapping("Account/{accNum}")
	public ResponseAccEntity getAccountByNumber(@PathVariable("accNum") String num);

}
