package com.moretii.apifirstserver.services;

import com.moreti.apifirst.model.Customer;
import com.moretii.apifirstserver.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> listCustomers() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false).toList();
    }

    @Override
    public Customer getCustomerById(UUID customerId) {
        return customerRepository.findById(customerId).orElseThrow();
    }
}
