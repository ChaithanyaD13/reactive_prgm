package com.exp.reactive_prgm.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exp.reactive_prgm.dto.Customer;
import com.exp.reactive_prgm.service.CustomerService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@GetMapping("/")
	public List<Customer> getCustomer(){
		return service.getCustomer();
		
	}                                                         //tradional way
	
	@GetMapping(value="/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE )
	public Flux<Customer> getCustomerStream(){
		return service.getCustomerStream();
	}

}


