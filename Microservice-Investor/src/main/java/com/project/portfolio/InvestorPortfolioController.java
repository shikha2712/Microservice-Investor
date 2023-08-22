package com.project.portfolio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.RemoteMutualFundRepository;

import com.project.mutualFund.MutualFund;

@RestController
public class InvestorPortfolioController {

	@Autowired
	InvestorPortfolioService iPService;
	
	@Autowired
	RemoteMutualFundRepository rmfRepository;
	
	@RequestMapping(value="/investorPortfolio",method=RequestMethod.GET)
	public List<InvestorPortfolio> getAllPortfolio()
	{
	    return (List<InvestorPortfolio>) iPService.getAllPortfolio();
	}
	
	@RequestMapping(value="/investorPortfolio",method=RequestMethod.POST)
	public String addPortfolio(@RequestBody InvestorPortfolio portfolio)
	{
	    return iPService.addPortfolio(portfolio);
	}
	
	@RequestMapping(value="/portfolio/{portfolioId}/mutualfunds",method=RequestMethod.GET,produces="application/json")
	public List<MutualFund> getInvestorFunds(@PathVariable(value="portfolioId") int portfolioId)
	{
		
		List<InvestorPortfolio> investorPortfolio = getAllPortfolio();
		List<MutualFund> allfunds =new ArrayList<>();
		InvestorPortfolio portfolio=null;
		
		for (InvestorPortfolio i:investorPortfolio)
		{
			if (i.getPortfolio_id()==portfolioId)
			{
				portfolio = i; // this customer obj will be returned if there is a match
				break;
			}
				
		}
		if(portfolio == null)
			return null;
		
		int mf_id=portfolio.getMfId(); // fetches all stock ids for this customer id
		
			
		MutualFund fund =rmfRepository.getFundById(mf_id);
		allfunds.add(fund);
		
		return allfunds;
		
		
	}
	
//	@RequestMapping(value="/portfolio/buyFund",method=RequestMethod.GET ,produces="application/json")
//	public boolean investorBuyFund(double amount,int fundId)
//	{
//	    return iPService.buyFund(amount,fundId);
//	}
//	
	
}
