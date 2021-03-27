package com.cts.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;



public class Country {
	private String code;
	private String name;
	
	private static final Logger logger=LoggerFactory.getLogger(Country.class);
	public Country() {
		logger.debug("inside country constructor");
		
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
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
	
	

}
