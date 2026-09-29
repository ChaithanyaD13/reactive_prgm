package com.exp.reactive_prgm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exp.reactive_prgm.dao.CustomerDao;
import com.exp.reactive_prgm.dto.Customer;

import reactor.core.publisher.Flux;

@Service
public class CustomerService {
	
	@Autowired
	CustomerDao dao;
	
	public List<Customer> getCustomer(){
		long startime=System.currentTimeMillis();
		List<Customer> customers=dao.getCustomer();
		long endtime=System.currentTimeMillis();
		System.out.println("total time: = " + (endtime-startime));
		return customers;                                                     //tradional way
	}

	public Flux<Customer> getCustomerStream() { 
		long startime=System.currentTimeMillis();
		Flux<Customer> customers=dao.getCustomerStream();
		long endtime=System.currentTimeMillis();
		System.out.println("total time taken : ="+ (endtime-startime));
		return customers;
	}

}
