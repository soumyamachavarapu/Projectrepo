package com.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.model.Order;
import com.order.repo.OrderRepo;


@Service
public class OrderHistoryImpl implements OrderHistory {
	@Autowired
	private OrderRepo orderRepo;
	
	
	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return this.orderRepo.findAll();
	}
	
	@Override
	public Order updatestatus(Order lobj,int order_id) {
		Optional<Order> orderoptional=this.orderRepo.findById(order_id);
		Order oObj;
		Order updatestatus=null;
		if(orderoptional.isPresent())
		{
			oObj=orderoptional.get();
			
			
			oObj.setUserID(lobj.getCar_id());
			oObj.setCar_id(lobj.getCar_id());
			oObj.setOrder_date(lobj.getOrder_date());
			oObj.setOrder_time(lobj.getOrder_time());
			oObj.setStatus(lobj.isStatus());
			
			updatestatus=this.orderRepo.save(oObj);
			
		}
		return updatestatus;
	
	}
	
	@Override
	public List<Order> getOrderByStatus(boolean status){
		
//		boolean status=false;
		return orderRepo.findBystatus(status);
	}

}
