package com.project.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
	@Autowired
	TransactionRepository tRepository;

	 public Iterable<InvestorTransaction> getAllTransaction()
	 {
		 return tRepository.findAll();
	 }
	 
	 public String addTransaction(InvestorTransaction transaction)
	 {
		 tRepository.save(transaction);
		 return "Successfully Added";
	 }
}

