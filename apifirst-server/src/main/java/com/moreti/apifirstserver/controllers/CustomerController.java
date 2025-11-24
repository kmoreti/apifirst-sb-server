package com.moreti.apifirstserver.controllers;

import com.moreti.apifirst.model.CustomerDto;
import com.moreti.apifirstserver.domain.Customer;
import com.moreti.apifirstserver.mappers.CustomerMapper;
import com.moreti.apifirstserver.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static com.moreti.apifirstserver.controllers.CustomerController.BASE_URL;

@RestController
@AllArgsConstructor
@RequestMapping(BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/v1/customers";

    private final CustomerService customerService;

    private final CustomerMapper customerMapper;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> listCustomers() {
        List<Customer> customers = customerService.listCustomers();
        return ResponseEntity.ok(customers.stream().map(customerMapper::customerToDto).toList());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") UUID customerId) {
        return ResponseEntity.ok(new CustomerDto());
//        return ResponseEntity.ok(customerMapper.customerToDto(customerService.getCustomerById(customerId)));
    }
}