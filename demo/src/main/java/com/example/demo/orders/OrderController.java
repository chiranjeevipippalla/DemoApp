package com.example.demo.orders;


import com.example.demo.orderproducts.OrderProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @PostMapping
    public String create(@RequestBody Order order) {

        List<OrderProduct> orderProducts = order.getOrderProducts();
        order.setOrderProducts(orderProducts);
        this.orderService.update(order);

        return "Order Created Successfully!";
    }
}
