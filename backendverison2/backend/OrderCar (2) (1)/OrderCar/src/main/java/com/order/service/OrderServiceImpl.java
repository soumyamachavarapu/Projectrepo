package com.order.service;

import java.time.Instant;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.order.model.Order;
import com.order.repo.OrderRepo;


@Service
public class OrderServiceImpl implements OrderService {
	
	
	@Autowired
	private OrderRepo orderRepo;
	
	 @Autowired
	 private MongoOperations mongoOperations;
	 
	 
	@Override
	public Order placeOrder(Order order) {
		// TODO Auto-generated method stub
		  Random random = new Random();

	        int randomOrder_id= random.nextInt(1000) + 1; // Generates a random integer from 1 to 1000
	        String uniqueId = Instant.now().toEpochMilli() + "-" + randomOrder_id;
	        order.setOrder_id(uniqueId);
	        order.setOrder_id(String.valueOf(randomOrder_id));

		String output;
		
		Order newOrder=null;
		newOrder=this.orderRepo.save(order);
		return newOrder;
	}

}
