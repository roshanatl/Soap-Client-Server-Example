package com.example.soapclient;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.soapclient.client.SOAPConnector;
import com.example.soapclient.consumer.soap.CreateCustomerRequest;
import com.example.soapclient.consumer.soap.CreateCustomerResponse;

@RestController
public class TestSoap {
	
	@Autowired
	private SOAPConnector soapConnector;

	@RequestMapping(value= "/test")
    public CreateCustomerResponse getAll() {
		CreateCustomerRequest cr = new CreateCustomerRequest();
		cr.setCustomerName("Roshan");
		cr.setCustomerAge(new BigInteger("26"));
		cr.setCustomerCity("TVM");
		cr.setCustomerPhoneNumber("12345");
		CreateCustomerResponse cRS=(CreateCustomerResponse)soapConnector.callWebService("http://localhost:9092/ws", cr);
		System.out.println(cRS.getDetails());
		System.out.println(cRS.getStatus());
		return cRS;
	}
	

}
