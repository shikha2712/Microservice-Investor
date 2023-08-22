package com.project.investor;
import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestorService {

	@Autowired
	InvestorRepository iRepository;
	
	public String addInvestor(Investor manager)
	{
		iRepository.save(manager);
		return "Successfully Added";
	}
	
	public ArrayList<Investor> getAllInvestors()
	{
		System.out.println("Calling all Investors from InvestorService JPA");
		ArrayList<Investor> allInvestors=new ArrayList<Investor>();	
		iRepository.findAll()
		.forEach(investor -> allInvestors.add(investor));	 	 	
		return allInvestors;
	}
	
	public String deleteById(int id)
	{
		iRepository.delete(id);
		return "Successfully Deleted";
	}
	
	public Boolean checkManager(String investorUsername,String password)
	{
		Investor investor = iRepository.findByUsernameAndPassword(investorUsername, password);
		if(Objects.nonNull(investor)&& investorUsername.equals(investor.getInvestorUsername()) && password.equals(investor.getPassword()))
		 return true;
		else 
			return false;
	}

}
