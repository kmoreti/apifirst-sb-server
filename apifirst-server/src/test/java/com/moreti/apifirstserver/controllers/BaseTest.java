package com.moreti.apifirstserver.controllers;

import com.moreti.apifirstserver.domain.Customer;
import com.moreti.apifirstserver.domain.Order;
import com.moreti.apifirstserver.domain.Product;
import com.moreti.apifirstserver.repositories.CustomerRepository;
import com.moreti.apifirstserver.repositories.OrderRepository;
import com.moreti.apifirstserver.repositories.ProductRepository;
import jakarta.servlet.Filter;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class BaseTest {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    WebApplicationContext webApplicationContext;
    @Autowired
    Filter validationFilter;

    Customer testCustomer;
    Product testProduct;
    Order testOrder;

    public MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilter(validationFilter).build();

        testCustomer = customerRepository.findAll().iterator().next();
        testProduct = productRepository.findAll().iterator().next();
        testOrder = orderRepository.findAll().iterator().next();
    }
}
