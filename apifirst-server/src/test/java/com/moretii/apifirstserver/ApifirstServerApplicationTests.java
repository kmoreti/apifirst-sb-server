package com.moretii.apifirstserver;

import com.moretii.apifirstserver.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class ApifirstServerApplicationTests {

    @Autowired
    CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

    @Test
    void testDataLoad() {
        assertThat(customerRepository.count()).isGreaterThan(0);
    }

}
