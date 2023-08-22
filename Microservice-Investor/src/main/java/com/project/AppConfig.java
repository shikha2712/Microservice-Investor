package com.project;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Configuration
@Component
public class AppConfig {
	
	public static final String MUTUALFUND_SERVICE_URL="http://Mutual-Fund-Microservice";
	@Bean
	public RemoteMutualFundRepository remoteRepository()
	{
		RemoteMutualFundRepository rsr=new RemoteMutualFundRepository(MUTUALFUND_SERVICE_URL);
		return rsr;
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTempate()
	{
		return new RestTemplate();
	}
}
