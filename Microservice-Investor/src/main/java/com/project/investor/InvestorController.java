package com.project.investor;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class InvestorController {

	@Autowired
	InvestorService is;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/investor",method=RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ArrayList<Investor> getAllInvestor()
	{
		System.out.println("Investor Controller");
		return is.getAllInvestors();
	}
	
	@RequestMapping(value="/investorLogin",method=RequestMethod.POST,produces= "application/json")
	public Boolean InvestorLogin(@RequestBody Investor newInvestor	)
	{
		return is.checkManager(newInvestor.getInvestorUsername(),newInvestor.getPassword());
	}
	
	@RequestMapping(value="/investor",method=RequestMethod.POST)
	public String addInvestor(@RequestBody Investor newInvestor	)
	{
		return is.addInvestor(newInvestor);
	}
	
	@RequestMapping(value="/investor/id/{id}",method=RequestMethod.DELETE)
	public String removeInvestor(@PathVariable("id") int cid) {
		System.out.println( "The investor id given is "+ cid);
		return is.deleteById(cid);
	}
	
	
	
}



