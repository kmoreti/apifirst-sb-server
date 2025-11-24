package com.moreti.apifirstserver.repositories;

import com.moreti.apifirstserver.domain.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<Order, UUID> {
}
