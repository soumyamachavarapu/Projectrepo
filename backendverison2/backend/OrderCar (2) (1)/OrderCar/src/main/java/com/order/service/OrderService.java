package com.order.service;

import org.springframework.stereotype.Service;

import com.order.model.Order;
@Service
public interface OrderService {
	public Order placeOrder(Order order);
}
