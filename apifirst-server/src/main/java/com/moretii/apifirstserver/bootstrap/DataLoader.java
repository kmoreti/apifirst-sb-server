package com.moretii.apifirstserver.bootstrap;

import com.moreti.apifirst.model.Address;
import com.moreti.apifirst.model.Customer;
import com.moreti.apifirst.model.Name;
import com.moreti.apifirst.model.PaymentMethod;
import com.moretii.apifirstserver.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;

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

        customerRepository.save(customer1);
        customerRepository.save(customer2);
    }
}
