package com.BankTransaction.TransRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.BankTransaction.TransEntity.TransEntity;

public interface TransRepo extends JpaRepository<TransEntity, Integer>{

	@Query(value="select * from transaction where accountnumber=:accountnumber",nativeQuery=true)
	List<TransEntity> findByAcc(@Param("accountnumber") String accountnumber);
	

	
}
