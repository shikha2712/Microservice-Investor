package com.project.investor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface InvestorRepository extends CrudRepository<Investor, Integer>  {

	@Query("select i from Investor i where i.investorUsername = :investorUsername and i.password = :password")
	Investor findByUsernameAndPassword(@Param("investorUsername") String username, @Param("password") String password);
}