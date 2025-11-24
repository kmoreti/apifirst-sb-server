package com.moreti.apifirstserver.controllers;

import com.moreti.apifirst.model.OrderDto;
import com.moreti.apifirstserver.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static com.moreti.apifirstserver.controllers.OrderController.BASE_URL;

@RestController
@RequestMapping(BASE_URL)
@AllArgsConstructor
public class OrderController {

    public static final String BASE_URL = "/v1/orders";

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDto>> listOrders() {
//        List<Order> orders = orderService.listOrders();
//        return ResponseEntity.ok(orders);
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("orderId") UUID orderId) {
//        return ResponseEntity.ok(orderService.getOrderById(orderId));
        return ResponseEntity.ok(null);
    }
}
