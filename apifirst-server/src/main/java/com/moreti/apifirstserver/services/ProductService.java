package com.moreti.apifirstserver.services;

import com.moreti.apifirst.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> listProducts();

    Product getProductById(UUID productId);
}
