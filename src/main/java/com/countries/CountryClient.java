package com.countries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.countries.wsdlClasses.GetCountryRequest;
import com.countries.wsdlClasses.GetCountryResponse;

public class CountryClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(CountryClient.class);

	public GetCountryResponse getCountry(String country) {
		System.out.println(country);
		GetCountryRequest request = new GetCountryRequest();
		request.setName(country);
		System.out.println("request="+request.getName());

		log.info("Requesting location for " + country);

		GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8080/ws/countries", request,
				new SoapActionCallback("http://io/guides/producing-web-service/GetCountryRequest"));

		return response;
	}

}
