package com.moreti.apifirstserver.services;

import com.moreti.apifirstserver.domain.Order;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    List<Order> listOrders();

    Order getOrderById(UUID orderId);
}
