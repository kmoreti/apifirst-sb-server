package com.moreti.apifirstserver.repositories;

import com.moreti.apifirstserver.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID> {
}
