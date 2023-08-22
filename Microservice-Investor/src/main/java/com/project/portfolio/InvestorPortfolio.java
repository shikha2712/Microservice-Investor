package com.project.portfolio;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.project.investor.Investor;


import io.swagger.annotations.ApiModel;

@JacksonXmlRootElement(namespace="InvestorPortfolio")
@ApiModel(description="Details about InvestorPortfolio")
@Entity
@Table(name="investor_portfolio")
public class InvestorPortfolio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int portfolio_id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "investorId")
	private Investor investor ;
	
    private int  mfId;
	
	@Column
	private double units;
	
	@Column
	private double amount_invested;
	
	@Column
	private double nav;
	
	
	public InvestorPortfolio() {
		// TODO Auto-generated constructor stub
	}


	public Investor getInvestor() {
		return investor;
	}


	public int getPortfolio_id() {
		return portfolio_id;
	}


	public void setPortfolio_id(int portfolio_id) {
		this.portfolio_id = portfolio_id;
	}
	
	


	public int getMfId() {
		return mfId;
	}


	public void setMfId(int mfId) {
		this.mfId = mfId;
	}


	public double getUnits() {
		return units;
	}


	public void setUnits(double units) {
		this.units = units;
	}


	public double getAmount_invested() {
		return amount_invested;
	}


	public void setAmount_invested(double amount_invested) {
		this.amount_invested = amount_invested;
	}


	public double getNav() {
		return nav;
	}


	public void setNav(double nav) {
		this.nav = nav;
	}


	public void setInvestor(Investor investor) {
		this.investor = investor;
	}


	public InvestorPortfolio(int portfolio_id, Investor investor, int mfId, double units, double amount_invested,
			double nav) {
		super();
		this.portfolio_id = portfolio_id;
		this.investor = investor;
		this.mfId = mfId;
		this.units = units;
		this.amount_invested = amount_invested;
		this.nav = nav;
	}


	@Override
	public String toString() {
		return "InvestorPortfolio [portfolio_id=" + portfolio_id + ", investor=" + investor + ", mfId="
				+ mfId + ", units=" + units + ", amount_invested=" + amount_invested + ", nav=" + nav
				+ "]";
	}


	
	
}

