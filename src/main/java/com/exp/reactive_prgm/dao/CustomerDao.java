package com.exp.reactive_prgm.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.exp.reactive_prgm.dto.Customer;

import reactor.core.publisher.Flux;

@Component
public class CustomerDao {
	
	public List<Customer> getCustomer ()
	{
		return IntStream.rangeClosed(1,10)
		
		 .peek(i->{
			 System.out.println("processing count:" +i);
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 })	
		 .mapToObj(i->new Customer(i,"customer" + i))
				.collect(Collectors.toList());                  //tradional way
		
	}
	
	
	public Flux<Customer> getCustomerStream(){
		return Flux.range(1, 10)
		.delayElements(Duration.ofSeconds(1))
		.doOnNext(i->System.out.println("processing count:" +i))
		.map(i->new Customer(i,"customer" + i));
	}
	

}
