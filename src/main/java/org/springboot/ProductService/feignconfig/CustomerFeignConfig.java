package org.springboot.ProductService.feignconfig;

import java.util.List;

import org.springboot.ProductService.responseDTO.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "CUSTOMERSERVICE", url="http://localhost:8082/api/customer")
public interface CustomerFeignConfig 
{
	@GetMapping()
	public List<Customer> getCustomer();
	
	
	@GetMapping("/{id}")
	public Customer getCustomerbyId(@PathVariable long id);
	
	
	@PostMapping()
	public String addCustomer(@RequestBody Customer customer);
	
	
	@PutMapping()
	public String updateCustomer(@RequestBody Customer customer);
	
	
	@PutMapping("/{id}")
	public Customer updateCustomerById(@PathVariable long id, @RequestBody Customer customer);
	
	
	@DeleteMapping()
	public Customer deleteCustomer(@RequestBody Customer customer);
	
	
	@DeleteMapping("/{id}")
	public Customer deleteCustomerById(@PathVariable long id);

}
