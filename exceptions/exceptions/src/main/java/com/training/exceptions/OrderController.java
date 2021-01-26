package com.training.exceptions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class OrderController {
	
	@Autowired
	private OrderService service;

	@GetMapping("/getPrice/{productName}")
	public String getOrderPrice(@PathVariable String productName) throws OrderServiceExp {
		double amount = service.getPrice(productName);
		return "amount for product " + productName + " is " + amount;
	}
}
