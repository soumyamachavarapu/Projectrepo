package com.order.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.order.model.Order;

@Repository
public interface OrderRepo extends MongoRepository<Order, Integer> {

	List<Order> findBystatus(boolean status);
}
