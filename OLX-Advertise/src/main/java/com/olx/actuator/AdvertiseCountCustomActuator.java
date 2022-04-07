package com.olx.actuator;

import java.util.Random;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "advstats")
public class AdvertiseCountCustomActuator {
	
	
	@ReadOperation
	public int getAllAdCount() {
		Random random = new Random();
		int randomNo = random.nextInt(100);
		System.out.println("Total No of Ads : " +randomNo);
		System.out.println("No of Open Ads : " +randomNo);
		System.out.println("No of Ads posted in a last month : " +randomNo);
		return randomNo;
		
	}

}
