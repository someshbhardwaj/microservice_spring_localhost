package com.learningwithsomesh.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//import com.in28minutes.microservices.currencyexchangeservice.ExchangeValue;

//Old way in which the URL is hardcoded
//@FeignClient(name="currency-exchange-service",url="localhost:8000")
//Below line is to make connection to currency-exchange-service
//@FeignClient(name="currency-exchange-service")
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service-mysql")
public interface CurrencyExchangeServiceProxy {
	//Old mapping to match with FeignClient
	//@GetMapping("/currency-exchange/from/{from}/to/{to}\")
	@GetMapping("/currency-exchange-service-mysql/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue
		(@PathVariable("from") String from, @PathVariable("to") String to) ;
}
