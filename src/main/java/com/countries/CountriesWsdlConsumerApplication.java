package com.countries;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.countries.wsdlClasses.GetCountryResponse;

@SpringBootApplication
public class CountriesWsdlConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountriesWsdlConsumerApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(CountryClient quoteClient) {
		return args -> {
			String country = "Spain";

			if (args.length > 0) {
				country = args[0];
			}
			GetCountryResponse response = quoteClient.getCountry(country);
			System.out.println("Country Name : "+ response.getCountry().getName());
			System.out.println("Country' Capital Name : "+ response.getCountry().getCapital());
			System.out.println("Country' Population : "+ response.getCountry().getPopulation());
			System.out.println("Country' Currency Name : "+ response.getCountry().getCurrency());
			
		};
	}

}
