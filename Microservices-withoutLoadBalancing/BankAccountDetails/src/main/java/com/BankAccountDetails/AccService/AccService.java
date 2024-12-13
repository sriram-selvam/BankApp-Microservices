package com.BankAccountDetails.AccService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankAccountDetails.AccEntitiy.AccEntitiy;
import com.BankAccountDetails.AccEntitiy.ResponseAccEntity;
import com.BankAccountDetails.AccRepo.AccountRepositoty;

@Service
public class AccService {

	
@Autowired
private AccountRepositoty accRepo;

@Autowired
private AccountFeign accountFeign;
	
	public List<ResponseAccEntity> getAllAccounts()
	{
		List<AccEntitiy> list =accRepo.findAll();
		List<ResponseAccEntity> resposes = new ArrayList<ResponseAccEntity>();
		
		for(AccEntitiy data: list)
		{
			ResponseAccEntity response= new ResponseAccEntity();
			BeanUtils.copyProperties(data, response);
			resposes.add(response);
		}
		
		
		return resposes;
	}
	
	public ResponseAccEntity getAccountByAccountNum(String num)
	{
		
	AccEntitiy list =accRepo.findByAccountNumber(num);
		ResponseAccEntity resposes = new ResponseAccEntity();
	BeanUtils.copyProperties(list, resposes);
	
		return resposes;
	}
	int bal=0;
	
	public String transactionImpl(String type, int amount, String accNum)
	{
	
		if(type.equals("cr"))
		{
			AccEntitiy list =accRepo.findByAccountNumber(accNum);
			bal=list.getBalance()+amount;
		   list.setBalance(bal);
		   AccEntitiy responses= new AccEntitiy();
		  BeanUtils.copyProperties(list, responses);
		  accRepo.save(responses);
		}
		else {
			AccEntitiy list =accRepo.findByAccountNumber(accNum);
			bal=list.getBalance()-amount;
		   list.setBalance(bal);
		   AccEntitiy responses= new AccEntitiy();
		  BeanUtils.copyProperties(list, responses);
		  accRepo.save(responses);
		}
		String msg=accountFeign.transactionImpl(type, amount, accNum);
//		AccEntitiy list =accRepo.findByAccountNumber();
		return msg+"\n Your balance is :"+bal;
		
	}
	
	
	
	
}
