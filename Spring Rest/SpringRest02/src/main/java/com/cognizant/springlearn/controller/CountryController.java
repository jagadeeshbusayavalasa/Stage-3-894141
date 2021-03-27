package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController

public class CountryController {
	
	@Autowired 
	
	CountryService service;
	
	private static final Logger logger=LoggerFactory.getLogger(CountryController.class);
	
	@RequestMapping("/country")
	public Country getCountryIndia()
	{
		logger.info("Start");
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		Country country=context.getBean("in",Country.class);
		logger.info("End");
		return country;
	}
	
	
	@GetMapping("/countries")
	public List<Country> getAllCountries()
	{
		logger.info("Start");
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> list=context.getBean("countryList",java.util.ArrayList.class);
		logger.info("End");
		return list;
	}
	
	@GetMapping("/countries/{code}")
	public List<Country> getCountry(@PathVariable String code) throws CountryNotFoundException
	{
		logger.info("Start");
		List<Country> list=service.getCountry(code);
		logger.info("End");
		return list;
	}

}
