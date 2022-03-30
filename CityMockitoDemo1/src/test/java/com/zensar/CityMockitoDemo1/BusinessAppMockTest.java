package com.zensar.CityMockitoDemo1;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BusinessAppMockTest {

//	@Test
//	public void testMockVsSpy() {
//		List mockList = mock(List.class);
//		((java.util.List<String>) mockList).add("ABC");
//		((java.util.List<String>) mockList).add("XYZ");
//		System.out.println("Mock : " +((java.util.List<String>) mockList).get(0));
//	}

	@Test
	public void testMockVsSpy() {
		List<String> mockList = mock(List.class); // 100 % mocking
		mockList.add("ABC");
		mockList.add("XYZ");
		System.out.println("Mock : " + mockList.get(1));

		List<String> list = new ArrayList<>();
		List<String> spyList = spy(list); // partial mocking
		spyList.add("ABC");
		spyList.add("XYZ");
		System.out.println("Spy : " + spyList.get(1));

	}

	@Test //(expected = NullPointerException.class) -- add then you want to handle exception 
	public void testBusinessApp() {
		CityService cityService = mock(CityService.class); // mock function internally creates stub class
		LoginService loginService = mock(LoginService.class);
		
		
		
		
		when(cityService.findCitiesByCountries("INDIA")).
		thenReturn(Arrays.asList("Pune", "Mumbai", "Delhi"));
		
		when(cityService.findCitiesByCountries("USA")).
		thenReturn(Arrays.asList("New York","Washigton"));
		
		when(cityService.findCitiesByCountries(anyString())).
				thenReturn(Arrays.asList("city1","city2","city3"));
		
//		when(cityService.findCitiesByCountries("SWEDEN")).
//		thenThrow(NullPointerException.class); // we need to handle by writing expected at @Test(...)
		
			BusinessApp businessApp = new BusinessApp(cityService, loginService);
//		assertEquals(businessApp.retrieveCityListByCountry("INDIA").size(), 3);
//		 assertEquals(businessApp.retrieveCityListByCountry("USA").size(), 3);
//		 assertEquals(businessApp.retrieveCityListByCountry("PAVAN").size(), 3);
		 assertEquals(businessApp.retrieveCityListByCountry("SWEDEN").size(), 3);
		 
		 boolean equals = equals(businessApp.login("Pavan", "98983984234"));

	}

}
