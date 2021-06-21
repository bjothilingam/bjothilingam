package guru.springframework.msscbrewery.services.v2;


import guru.springframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerServiceV2 {

    CustomerDto getCustomerById(UUID customerId);

    CustomerDto createCustomer(CustomerDto customerDto);

    void updateCustomer(UUID customerId, CustomerDto customerDto);

    void deleteCustomer(UUID customerId);
}








