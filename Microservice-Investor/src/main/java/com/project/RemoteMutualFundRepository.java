package com.project;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.project.mutualFund.MutualFund;

public class RemoteMutualFundRepository {

	@Autowired
	protected RestTemplate restTemplate;
	
	protected String serviceUrl;
	MutualFund mutualFund[];
	ArrayList<MutualFund> mutualFundList;
	
	public RemoteMutualFundRepository(String serviceUrl) {
 		//http://stocks-microserice
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	
	public void getAllMutualFunds() {
		mutualFund = restTemplate.getForObject(serviceUrl+"/mutualfunds", MutualFund[].class);
		mutualFundList=new ArrayList<MutualFund>(Arrays.asList(mutualFund));
				
	}
	
	public MutualFund getFundById(int mutualFundId) {
		System.out.println("serviceUrl is "+serviceUrl + "/mutualfunds/{id}");
		// http://stocks-microservice/stocks/4
		return restTemplate.getForObject(serviceUrl + "/mutualfunds/{id}",
				MutualFund.class, mutualFundId);
	}
	
}


