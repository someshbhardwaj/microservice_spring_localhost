package com.learningwithsomesh.microservices.currencyexchangeservice;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;


@EnableDiscoveryClient
@SpringBootApplication
public class CurrencyExchangeServiceApplicationMySQL {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplicationMySQL.class, args);
	}

	@Bean
	public Sampler defaultSample() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
