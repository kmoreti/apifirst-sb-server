package com.moreti.apifirstserver.repositories;

import com.moreti.apifirst.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {

}
