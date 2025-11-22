package com.moreti.apifirstserver.repositories;

import com.moreti.apifirst.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<Order, UUID> {
}
