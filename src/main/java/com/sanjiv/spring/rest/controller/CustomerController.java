package com.sanjiv.spring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanjiv.spring.rest.service.CustomerService;
import com.sanjiv.spring.rest.entity.Customer;
import com.sanjiv.spring.rest.exception.CustomerNotFoundException;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		 Customer customer = customerService.getCustomer(customerId);
		 
		 if(customer == null) {
			 throw new CustomerNotFoundException("Customer not found:"+customerId);
		 }
		 
		 return customer;
	}
	
	@PostMapping("/customers")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
	}
	
	@DeleteMapping("/customers/{customerId}")
	public void deleteCustomer(@PathVariable int customerId) {
		customerService.deleteCustomer(customerId);
	}
	
	@PutMapping("/customers")
	public void updateCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
	}
		
	
}
