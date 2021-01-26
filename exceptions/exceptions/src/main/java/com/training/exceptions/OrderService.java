package com.training.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repo;

	public void addOrder2DB() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(876, 2000, "Electronics"));
		orders.add(new Order(806, 1000, "Vehicle"));
		repo.saveAll(orders);
	}

	public double getPrice(String productName) throws OrderServiceExp {
		Order order = null;
		double amount = 0;
		try {
			order = (Order) repo.findByName(productName);
			amount = order.getAmount();
		} catch (Exception e) {
			throw new OrderServiceExp("order not found with product : " + productName);
		}
		return amount;
	}
}