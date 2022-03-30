package com.zensar.CityMockitoDemo1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BusinessAppTest {

	@Test
	public void testBusinessApp() {
		CityService cityService = new CityServiceStub(); //new CityServiceImpl();
		
		LoginService loginService = new LoginServiceStub();
		
		BusinessApp businessApp = new BusinessApp(cityService, loginService);
//		assertEquals(businessApp.retrieveCityListByCountry("INDIA").size(), 3);
		assertEquals(businessApp.retrieveCityListByCountry("USA").size(), 2);
		
		boolean equals = equals(businessApp.login("Pavan", "0898923434"));

	}	

}
