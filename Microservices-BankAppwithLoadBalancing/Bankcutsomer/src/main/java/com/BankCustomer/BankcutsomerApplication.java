package com.BankCustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BankcutsomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankcutsomerApplication.class, args);
		System.out.println("BankCustomer APplication Started");
	}

}
