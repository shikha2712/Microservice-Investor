package com.project.transaction;
import java.util.Date;


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


@JacksonXmlRootElement(namespace="InvestorTransaction")
@ApiModel(description="Details about Transaction")
@Entity
@Table(name="investor_transaction")
public class InvestorTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transaction_id;
	
	@ManyToOne
	@JoinColumn(name="investor_Id")
	private Investor investor;
	
//	@Column
//	private int mfIds[];
	
	@Column
	private String transaction_type;
	
	@Column
	private int units;
	
	@Column
	private int transaction_amount;
	
	@Column
	private Date transaction_date;
	

	public int getTransaction_id() {
		return transaction_id;
	}




	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}




	public Investor getInvestor() {
		return investor;
	}




	public void setInvestor(Investor investor) {
		this.investor = investor;
	}



//
//	public int[] getMfIds() {
//		return mfIds;
//	}
//
//
//
//
//	public void setMfIds(int[] mfIds) {
//		this.mfIds = mfIds;
//	}




	public String getTransaction_type() {
		return transaction_type;
	}




	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}




	public int getUnits() {
		return units;
	}




	public void setUnits(int units) {
		this.units = units;
	}




	public int getTransaction_amount() {
		return transaction_amount;
	}




	public void setTransaction_amount(int transaction_amount) {
		this.transaction_amount = transaction_amount;
	}




	public Date getTransaction_date() {
		return transaction_date;
	}




	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}




	public InvestorTransaction(int transaction_id, Investor investor, String transaction_type, int units,
			int transaction_amount, Date transaction_date) {
		super();
		this.transaction_id = transaction_id;
		this.investor = investor;
	
		this.transaction_type = transaction_type;
		this.units = units;
		this.transaction_amount = transaction_amount;
		this.transaction_date = transaction_date;
	}




	public InvestorTransaction() {
		// TODO Auto-generated constructor stub
	}

}