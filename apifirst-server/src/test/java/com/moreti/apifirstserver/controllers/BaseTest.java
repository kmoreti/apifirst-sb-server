package com.moreti.apifirstserver.controllers;

import com.moreti.apifirstserver.repositories.CustomerRepository;
import com.moreti.apifirstserver.repositories.OrderRepository;
import com.moreti.apifirstserver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
public class BaseTest {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    public MockMvc mockMvc;
}
