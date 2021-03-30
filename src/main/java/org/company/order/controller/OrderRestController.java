package org.company.order.controller;

import org.company.order.service.OrderService;
import org.company.order.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    /**
     *
     * @param order
     * @return
     */

    @GetMapping(value = "/order")
    public Order getTotalOrder(@RequestBody Order order){

        return orderService.getTotalOrder(order);
    }

}
