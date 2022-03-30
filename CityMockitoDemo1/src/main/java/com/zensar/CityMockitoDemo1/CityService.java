package com.zensar.CityMockitoDemo1;

import java.util.List;

public interface CityService {
	List<String> findCitiesByCountries(String country);
}
