package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.model.Order;
import com.order.service.OrderHistory;
import com.order.service.OrderService;

@RestController
@RequestMapping("api/order")
@CrossOrigin(origins = "http://localhost:53223")
public class OrderController {

    @Autowired
    private OrderHistory orderHistory;
    
    @Autowired
    private OrderService orderService;

    private ResponseEntity<?> responseEntity;

    @GetMapping("/getAllOrder")
    public ResponseEntity<?> getAllOrderHandler() {
        List<Order> allOrder = orderHistory.getAllOrder();
        responseEntity = new ResponseEntity<>(allOrder, HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/updatestatus/{order_id}")
    public ResponseEntity<?> updatestatusHandler(@RequestBody Order oObj, @PathVariable int order_id) {
        Order neworder = orderHistory.updatestatus(oObj, order_id);
        responseEntity = new ResponseEntity<>(neworder, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/getorderByStatus/{status}")
    public ResponseEntity<?> getOrderByStatus(@PathVariable boolean status) {
        List<Order> oObj = orderHistory.getOrderByStatus(status);
        responseEntity = new ResponseEntity<>(oObj, HttpStatus.OK);
        return responseEntity;
    }
    
    
    @PostMapping("/place")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        Order newOrder = orderService.placeOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);
    }

}
