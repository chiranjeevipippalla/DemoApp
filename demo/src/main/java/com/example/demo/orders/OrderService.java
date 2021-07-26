package com.example.demo.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }


    public Order create(Order order) {
        //order.setDateCreated(LocalDate.now());
        return this.orderRepository.save(order);
    }


    public void update(Order order) {
        this.orderRepository.save(order);
    }
}
