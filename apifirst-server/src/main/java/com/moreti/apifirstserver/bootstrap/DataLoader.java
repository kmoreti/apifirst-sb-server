package com.moreti.apifirstserver.bootstrap;

import com.moreti.apifirst.model.*;
import com.moreti.apifirstserver.repositories.CustomerRepository;
import com.moreti.apifirstserver.repositories.OrderRepository;
import com.moreti.apifirstserver.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        Address address1 = Address.builder()
                .addressLine1("123 Main St")
                .city("Springfield")
                .state("IL")
                .zip("62701")
                .build();

        Customer customer1 = Customer.builder()
                .name(Name.builder()
                        .firstName("John")
                        .lastName("Thompson")
                        .build())
                .billToAddress(address1)
                .shipToAddress(address1)
                .email("john@springframework.guru")
                .phone("800-555-1212")
                .paymentMethods(List.of(PaymentMethod.builder()
                        .displayName("My Master Card")
                        .cardNumber(12341234)
                        .expiryMonth(12)
                        .expiryYear(26)
                        .cvv(321)
                        .build()))
                .build();

        Address address2 = Address.builder()
                .addressLine1("456 Elm St")
                .city("Metropolis")
                .state("NY")
                .zip("10001")
                .build();

        Customer customer2 = Customer.builder()
                .name(Name.builder()
                        .firstName("Jane")
                        .lastName("Doe")
                        .build())
                .billToAddress(address2)
                .shipToAddress(address2)
                .email("jim@springframework.guru")
                .phone("800-555-1213")
                .paymentMethods(List.of(PaymentMethod.builder()
                        .displayName("My Visa Card")
                        .cardNumber(56785678)
                        .expiryMonth(11)
                        .expiryYear(25)
                        .cvv(123)
                        .build()))
                .build();

        Customer savedCustomer1 = customerRepository.save(customer1);
        Customer savedCustomer2 = customerRepository.save(customer2);

        Product product1 = Product.builder().description("Product 1")
                .price("19.99")
                .cost("9.99")
                .categories(List.of(
                        Category.builder()
                                .id(UUID.randomUUID())
                                .category("Category A")
                                .description("Category A Description")
                                .build(),
                        Category.builder()
                                .id(UUID.randomUUID())
                                .category("Category B")
                                .description("Category B Description")
                                .build()
                ))
                .images(List.of(
                        Image.builder()
                                .id(UUID.randomUUID())
                                .url("http://example.com/image1.jpg")
                                .altText("Image 1")
                                .build(),
                        Image.builder()
                                .id(UUID.randomUUID())
                                .url("http://example.com/image2.jpg")
                                .altText("Image 2")
                                .build()
                ))
                .dimensions(Dimensions.builder()
                        .length(10)
                        .width(5)
                        .height(2)
                        .build())
                .build();

        Product product2 = Product.builder().description("Product 2")
                .price("29.99")
                .cost("14.99")
                .categories(List.of(
                        Category.builder()
                                .category("Category C")
                                .description("Category C Description")
                                .build()
                ))
                .images(List.of(
                        Image.builder()
                                .url("http://example.com/image3.jpg")
                                .altText("Image 3")
                                .build()
                ))
                .dimensions(Dimensions.builder()
                        .length(15)
                        .width(7)
                        .height(3)
                        .build())
                .build();

        Product savedProduct1 = productRepository.save(product1);
        Product savedProduct2 = productRepository.save(product2);

        Order order1 = Order.builder()
                .customer(OrderCustomer.builder()
                        .id(savedCustomer1.getId())
                        .name(savedCustomer1.getName())
                        .billToAddress(savedCustomer1.getBillToAddress())
                        .shipToAddress(savedCustomer1.getShipToAddress())
                        .email(savedCustomer1.getEmail())
                        .phone(savedCustomer1.getPhone())
                        .selectedPaymentMethod(savedCustomer1.getPaymentMethods().get(0))
                        .build())
                .orderStatus(Order.OrderStatusEnum.NEW)
                .shipmentInfo("shipment info")
                .orderLines(List.of(OrderLine.builder()
                                .product(OrderProduct.builder()
                                        .id(savedProduct1.getId())
                                        .description(product1.getDescription())
                                        .price(product1.getPrice())
                                        .build())
                                .orderQuantity(1)
                                .shipQuantity(1)
                                .build(),
                        OrderLine.builder()
                                .product(OrderProduct.builder()
                                        .id(savedProduct2.getId())
                                        .description(product2.getDescription())
                                        .price(product1.getPrice())
                                        .build())
                                .orderQuantity(1)
                                .shipQuantity(1)
                                .build()))
                .build();

        Order order2 = Order.builder()
                .customer(OrderCustomer.builder()
                        .id(savedCustomer2.getId())
                        .name(savedCustomer2.getName())
                        .billToAddress(savedCustomer2.getBillToAddress())
                        .shipToAddress(savedCustomer2.getShipToAddress())
                        .email(savedCustomer2.getEmail())
                        .phone(savedCustomer2.getPhone())
                        .selectedPaymentMethod(savedCustomer2.getPaymentMethods().get(0))
                        .build())
                .orderStatus(Order.OrderStatusEnum.NEW)
                .shipmentInfo("shipment info #2")
                .orderLines(List.of(OrderLine.builder()
                                .product(OrderProduct.builder()
                                        .id(savedProduct1.getId())
                                        .description(product1.getDescription())
                                        .price(product1.getPrice())
                                        .build())
                                .orderQuantity(1)
                                .shipQuantity(1)
                                .build(),
                        OrderLine.builder()
                                .product(OrderProduct.builder()
                                        .id(savedProduct2.getId())
                                        .description(product2.getDescription())
                                        .price(product1.getPrice())
                                        .build())
                                .orderQuantity(1)
                                .shipQuantity(1)
                                .build()))
                .build();

        orderRepository.save(order1);
        orderRepository.save(order2);
    }
}
