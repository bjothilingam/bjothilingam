package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerControllerTest {

    @Autowired
    CustomerController customerController;

    @Test
    void getCustomerById() {
        customerController.getCustomerById(UUID.randomUUID());
    }

    @Test
    void createCustomer() {
        customerController.createCustomer(CustomerDto.builder().customerName("bala").build());
    }

    @Test
    void updateCustomer() {
        customerController.updateCustomer(UUID.randomUUID(), CustomerDto.builder().customerName("bala").build());
    }

    @Test
    void deleteCustomer() {
        customerController.deleteCustomer(UUID.randomUUID());
    }

}