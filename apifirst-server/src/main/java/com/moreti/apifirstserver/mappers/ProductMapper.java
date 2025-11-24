package com.moreti.apifirstserver.mappers;

import com.moreti.apifirst.model.ProductDto;
import com.moreti.apifirstserver.domain.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product dtoToProduct(ProductDto productDto);
    ProductDto productToDto(Product product);
}
