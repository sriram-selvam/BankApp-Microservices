package com.BankAccountDetails.AccRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.BankAccountDetails.AccEntitiy.AccEntitiy;

public interface AccountRepositoty extends JpaRepository<AccEntitiy, Integer>{

	@Query(value="select * from accountDetail where accountnumber= :accountNumber",nativeQuery=true)
	AccEntitiy findByAccountNumber(@Param("accountNumber") String accountNumber);
	
	
	
}
