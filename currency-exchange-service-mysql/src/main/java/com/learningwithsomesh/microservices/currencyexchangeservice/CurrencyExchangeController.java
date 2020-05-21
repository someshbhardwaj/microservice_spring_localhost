package com.learningwithsomesh.microservices.currencyexchangeservice;

import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	//Using org.springframework.core.env.Environment
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository repostiory;
	
	//private Logger logger = Logger.getLogger(getClass().getName());
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = repostiory.findByFromAndTo(from, to);
				
				//OLD HARDCODED WAY
				/*
				 * ExchangeValue exchangeValue =
				 * 				new ExchangeValue(1000L,from,to,BigDecimal.valueOf(65)); 
				 */
				
		logger.info("{}", exchangeValue);
		//Fetching the port locally but using correct way. NOT HARDCODED WAY
		exchangeValue.setPort(
				Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}
}
