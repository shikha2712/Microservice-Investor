package com.project.portfolio;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestorPortfolioService {

	@Autowired
	InvestorPortfolioRepository portfolioRepository;
	
	public Iterable<InvestorPortfolio> getAllPortfolio()
	{
		return portfolioRepository.findAll();
	}
	
	public String addPortfolio(InvestorPortfolio portfolio) {
		portfolioRepository.save(portfolio);
		return "Successfully Added";
	}

//	public boolean buyFund(double amount, int fundId) {
//        InvestorPortfolio portfolio = portfolioRepository.findById(fundId).orElse(null);
//
//        if (portfolio == null) {
//            // Fund not found
//            return false;
//        }
//
//        double currentBalance = portfolio.getBalance();
//        if (currentBalance < amount) {
//            // Insufficient balance to buy the fund
//            return false;
//        }
//
//        // Deduct the amount from the balance and update the portfolio
//        double newBalance = currentBalance - amount;
//        portfolio.setBalance(newBalance);
//        portfolioRepository.save(portfolio);
//
//        return true;
//    }
}
