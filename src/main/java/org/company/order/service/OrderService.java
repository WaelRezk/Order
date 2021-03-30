package org.company.order.service;

import org.company.order.domain.Order;

public interface OrderService {
    Order getTotalOrder(Order order);
}
