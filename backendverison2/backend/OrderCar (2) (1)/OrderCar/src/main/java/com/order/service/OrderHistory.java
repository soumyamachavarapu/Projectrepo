package com.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.order.model.Order;


@Service
public interface OrderHistory {
	public List<Order> getAllOrder();
	public Order updatestatus(Order lobj,int order_id);
	public List<Order> getOrderByStatus(boolean status);
}
