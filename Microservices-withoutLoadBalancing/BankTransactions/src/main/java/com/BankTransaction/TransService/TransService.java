package com.BankTransaction.TransService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankTransaction.TransEntity.ResponseTransEntity;
import com.BankTransaction.TransEntity.TransEntity;
import com.BankTransaction.TransRepo.TransRepo;

@Service
public class TransService {

	
	@Autowired
	private TransRepo transRepo;
	
	@Autowired
	private TransFeignClient transFeign;
	
	
	
	public List<ResponseTransEntity> getTransDetails(String num)
	{
		List<TransEntity> entityResponse= transRepo.findByAcc(num);
			List<ResponseTransEntity> transList= new ArrayList<ResponseTransEntity>();
			for(TransEntity data: entityResponse)
			{
				ResponseTransEntity responses= new ResponseTransEntity();
				BeanUtils.copyProperties(data, responses);
				transList.add(responses);
				
			}
	
		
		return transList;
	}
	String type="";
	public String transServiceImpl(String type, int amount, String accNum)
	{
		TransEntity pos = new TransEntity();
	String transId="";
	int bal=0;
		if(type.equals("cr"))
		{
			
		pos.setTransactiontype("Credited");
	
//		ResponseAccEntity rsAcc = transFeign.getAccountByNumber(accNum); 
		 int randomNum = ThreadLocalRandom.current().nextInt(1000, 10000);
		  transId= "TR"+randomNum;
		 pos.setAmount(amount);
		 pos.setAccountnumber(accNum);
         pos.setTransactionid(transId);
         transRepo.save(pos);
		
		}
		else {
			pos.setTransactiontype("Debited");
			
//			ResponseAccEntity rsAcc = transFeign.getAccountByNumber(accNum); 
			 int randomNum = ThreadLocalRandom.current().nextInt(1000, 10000);
			  transId= "TR"+randomNum;
			 pos.setAmount(amount);
			 pos.setAccountnumber(accNum);
	         pos.setTransactionid(transId);
	         transRepo.save(pos);
			
		}
		type=pos.getTransactiontype();
		return "\n The current transaction details:"
				+ "\n amount "+ type+": " + amount +"\n Transaction id:"+ transId;
	}
	
}
