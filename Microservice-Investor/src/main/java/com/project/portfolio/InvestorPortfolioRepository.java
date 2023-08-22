package com.project.portfolio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestorPortfolioRepository extends CrudRepository<InvestorPortfolio, Integer>{

	@Query(value="Select mf_id from investor_portfolio where investor_id = ?",nativeQuery=true)
	 float getStockPrice(int stock_id);
}
