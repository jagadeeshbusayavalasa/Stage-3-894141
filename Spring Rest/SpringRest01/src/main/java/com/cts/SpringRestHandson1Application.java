package com.cts;

import java.text.ParseException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.model.Country;

@SpringBootApplication
public class SpringRestHandson1Application {
	
	private static final Logger logger=LoggerFactory.getLogger(SpringRestHandson1Application.class);

	private static void displayCountry()
	{
		
		@SuppressWarnings("resource")
	
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		Country country=(Country)context.getBean("country",Country.class);
		logger.info("start");
		logger.debug("country : {}",country);
		//Country anotherCountry=context.getBean("country",Country.class);
		//logger.info("country : {}", anotherCountry);
		logger.info("End");
		
	}
	
	private static void displayCountries()
	{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> list=context.getBean("countryList",java.util.ArrayList.class);
		logger.info("start");
		logger.debug("List: {}", list);
		logger.info("End");
		
		
	}
	public static void main(String[] args) throws ParseException{
		SpringApplication.run(SpringRestHandson1Application.class, args);
		displayCountry();
		displayCountries();
		
	}

}
