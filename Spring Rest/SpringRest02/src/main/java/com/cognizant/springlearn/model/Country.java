package com.cognizant.springlearn.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
	
	private String code;
	private String name;
	
	private static Logger logger=LoggerFactory.getLogger(Country.class);
	
	public Country() {
		super();
	
	}
	public Country(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
