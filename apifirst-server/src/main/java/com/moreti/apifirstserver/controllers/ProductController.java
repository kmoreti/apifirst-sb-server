package com.moreti.apifirstserver.controllers;

import com.moreti.apifirst.model.ProductDto;
import com.moreti.apifirstserver.domain.Product;
import com.moreti.apifirstserver.mappers.ProductMapper;
import com.moreti.apifirstserver.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

import static com.moreti.apifirstserver.controllers.ProductController.BASE_URL;

@RestController
@AllArgsConstructor
@RequestMapping(BASE_URL)
public class ProductController {

    public static final String BASE_URL = "/v1/products";

    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<Void> createProduct(@Valid @RequestBody ProductDto productDto) {
        Product savedProduct = productService.saveNewProduct(productMapper.dtoToProduct(productDto));
        UriComponents uriComponents = UriComponentsBuilder.fromPath(BASE_URL + "/{productId}").buildAndExpand(savedProduct.getId());
        return ResponseEntity.created(uriComponents.toUri()).build();
    }
    @GetMapping
    public ResponseEntity<List<ProductDto>> listProducts() {
        List<Product> products = productService.listProducts();
        return ResponseEntity.ok(products.stream().map(productMapper::productToDto).toList());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("productId") UUID productId) {
        return ResponseEntity.ok(productMapper.productToDto(productService.getProductById(productId)));
    }

}
