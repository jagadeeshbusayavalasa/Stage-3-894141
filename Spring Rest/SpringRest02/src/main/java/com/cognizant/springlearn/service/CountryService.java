package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service

public class CountryService {
	
	
	private Country country;
	
	public List<Country> getCountry(String code) throws CountryNotFoundException
	{
	
	ArrayList<Country> list1=new ArrayList<Country>();
	ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
	ArrayList<Country> list=context.getBean("countryList",java.util.ArrayList.class);
	
	for(Country countrylist:list)
	{
		if(countrylist.getCode().equalsIgnoreCase(code))
		{
			list1.add(countrylist);
		}
		if(list1.isEmpty())
		{
			throw new CountryNotFoundException("Country not found");
		}
	}
	return list1;
	
	}
}
