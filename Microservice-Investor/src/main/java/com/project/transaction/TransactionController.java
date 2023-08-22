package com.project.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TransactionController {

	@Autowired
	TransactionService ts;
	
	
	@RequestMapping(value="/Transaction",method=RequestMethod.GET)
	public List<InvestorTransaction> getAllTransaction()
	{
	    return  (List<InvestorTransaction>) ts.getAllTransaction();
	}
	
	@RequestMapping(value="/Transaction",method=RequestMethod.POST)
	public String addTransactions(InvestorTransaction transaction)
	{
	    return ts.addTransaction(transaction);
	}
	
	
	
	
	
}
