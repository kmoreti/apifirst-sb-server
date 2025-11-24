package com.moreti.apifirstserver.controllers;

import com.moreti.apifirst.model.CategoryDto;
import com.moreti.apifirst.model.DimensionsDto;
import com.moreti.apifirst.model.ImageDto;
import com.moreti.apifirst.model.ProductDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class ProductControllerTest extends BaseTest{

    @Test
    void testCreateProduct() throws Exception {
        ProductDto newProduct = ProductDto.builder()
                .description("This is a test product")
                .cost("5.00")
                .price("19.99")
                .categories(List.of(CategoryDto.builder()
                        .category("Test Category")
                        .description("This is a test category").build()))
                .images(List.of(ImageDto.builder()
                        .url("http://example.com/image.jpg")
                        .altText("Image Alt Text").build()))
                .dimensions(DimensionsDto.builder()
                        .length(10)
                        .width(10)
                        .height(10).build())
                .build();
        mockMvc.perform(post(ProductController.BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newProduct)))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"));
    }

    @DisplayName("Test List Products")
    @Test
    void testListProducts() throws Exception{
        mockMvc.perform(get(ProductController.BASE_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", greaterThan(0)));
    }

    @DisplayName("Test Get Product by ID")
    @Test
    void testGetProductById() throws Exception{
        mockMvc.perform(get(ProductController.BASE_URL + "/" + testProduct.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(testProduct.getId().toString()));
    }
}
