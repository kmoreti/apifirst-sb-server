package com.moretii.apifirstserver.controllers;

import com.moreti.apifirst.model.Customer;
import com.moretii.apifirstserver.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static com.moretii.apifirstserver.controllers.CustomerController.BASE_URL;

@RestController
@AllArgsConstructor
@RequestMapping(BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/v1/customers";

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> listCustomers() {
        List<Customer> customers = customerService.listCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") UUID customerId) {
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }
}
