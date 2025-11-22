package com.moreti.apifirstserver.controllers;

import com.moreti.apifirst.model.Customer;
import com.moreti.apifirstserver.repositories.CustomerRepository;
import com.moreti.apifirstserver.repositories.OrderRepository;
import com.moreti.apifirstserver.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
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

    Customer testCustomer;

    @Autowired
    public MockMvc mockMvc;

    @BeforeEach
    void setup() {
        testCustomer = customerRepository.findAll().iterator().next();
    }
}
