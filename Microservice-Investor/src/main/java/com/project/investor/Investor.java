package com.project.investor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JacksonXmlRootElement(namespace="Investor")
@ApiModel(description="Details about Investor")
@Entity
@Table(name = "investor")
public class Investor {

	@Id
	@ApiModelProperty(notes="Id of the Investor")
	private int investorId;
	private String investorName;
	private String investorUsername;
	private String password;
	
	public Investor() {
		// TODO Auto-generated constructor stub
	}

	public Investor(int investorId, String investorName, String investorUsername, String password) {
		super();
		this.investorId = investorId;
		this.investorName = investorName;
		this.investorUsername = investorUsername;
		this.password = password;
	}

	public int getInvestorId() {
		return investorId;
	}

	public void setInvestorId(int investorId) {
		this.investorId = investorId;
	}

	public String getInvestorName() {
		return investorName;
	}

	public void setInvestorName(String investorName) {
		this.investorName = investorName;
	}

	public String getInvestorUsername() {
		return investorUsername;
	}

	public void setInvestorUsername(String investorUsername) {
		this.investorUsername = investorUsername;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
