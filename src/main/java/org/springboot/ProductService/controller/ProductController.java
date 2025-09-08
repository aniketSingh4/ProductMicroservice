package org.springboot.ProductService.controller;

import java.util.List;

import org.springboot.ProductService.feignconfig.CustomerFeignConfig;
import org.springboot.ProductService.model.Product;
import org.springboot.ProductService.responseDTO.Customer;
import org.springboot.ProductService.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController 
{
	@Autowired
	private ProductServiceImpl productSer;
	
	@Autowired
	private CustomerFeignConfig customerCon;
	
	//Method of customer which i call from the product service
	@GetMapping("/customer")
	public List<Customer> getCustomer()
	{
		return customerCon.getCustomer();
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable long id)
	{
		return customerCon.getCustomerbyId(id);
	}
	
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		 customerCon.addCustomer(customer);
		 return customer;
	}
	
	@PutMapping("/customer")
	public Customer updateCustomer(@RequestBody Customer customer)
	{
		customerCon.updateCustomer(customer);
		return customer;
	}
	
	@PutMapping("/customer/{id}")
	public Customer updateCustomer(@PathVariable long id, @RequestBody Customer customer)
	{
		return customerCon.updateCustomerById(id, customer);
	}
	
	@DeleteMapping("/customer")
	public Customer deleteCustomer(@RequestBody Customer customer)
	{
		return customerCon.deleteCustomer(customer);
	}
	
	@DeleteMapping("/customer/{id}")
	public Customer deleteCustomer(@PathVariable long id)
	{
		return customerCon.deleteCustomerById(id);
	}
	
	
	
	//Specific method of Product Service
	@GetMapping()
	public void getProductController()
	{
		System.out.println("This is a Product Controller.");
	}
	
	@GetMapping("/{id}")
	Product getProductById(@PathVariable long id)
	{
		return productSer.getProductById(id);
	}
	
	@GetMapping()
	List<Product> getAllProduct()
	{
		return productSer.getAllProduct();
	}
	
	@PostMapping()
	String addProductIntoDB(@RequestBody Product product)
	{
		productSer.addProduct(product);
		return "Product DATA Added.";
	}
	
	@PutMapping()
	String updateProductIntoDB(@RequestBody Product product)
	{
		productSer.updateProduct(product);
		//productSer.addProduct(product);
		return "Product Data Updated.";
	}
	
	@PutMapping("/{id}")
	Product updateProductIntoDB(@PathVariable long id, @RequestBody Product product)
	{
		return productSer.updateProduct(id, product);
	}
	
	@DeleteMapping("/{id}")
	String deleteProductById(@PathVariable long id)
	{
		productSer.deleteProductById(id);
		return "Product Data Deleted By Id.";
	}
	
	@DeleteMapping()
	String deleteProduct(@RequestBody Product product)
	{
		productSer.deleteProduct(product);
		return "Product Data Deleted.";
	}
}
