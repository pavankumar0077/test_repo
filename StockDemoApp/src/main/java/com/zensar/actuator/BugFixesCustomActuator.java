package com.zensar.actuator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "bug-fixes")
public class BugFixesCustomActuator {

	private Map<String, List<String>> bugFixesByVersionMap = new HashMap<>();

	@PostConstruct
	public void init() {
		bugFixesByVersionMap.put("v1", Arrays.asList("Invalid status issue", "Application closing not working"));
		bugFixesByVersionMap.put("v2",
				Arrays.asList("Window size change not working", "Window minimizing not working"));
	}

	@ReadOperation
	public Map<String, List<String>> getAllBugFixes() {
		return this.bugFixesByVersionMap;
	}
}
