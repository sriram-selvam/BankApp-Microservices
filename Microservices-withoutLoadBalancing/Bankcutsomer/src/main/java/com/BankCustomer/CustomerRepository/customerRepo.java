package com.BankCustomer.CustomerRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.BankCustomer.customerEntity.CustomerEntity;

public interface customerRepo extends JpaRepository<CustomerEntity, Integer>{

	
	@Query(value="select * from customer where accountnumber=:accountNumber", nativeQuery = true)
	CustomerEntity getAccountDetails(@Param("accountNumber")String  accountNumber);
}
