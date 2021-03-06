package guru.springframework.msscbrewery.services.v2;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImplV2 implements CustomerServiceV2 {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID()).customerName("Bala").build();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        log.debug("Creating new customer");
        return CustomerDto.builder().id(UUID.randomUUID()).customerName("Bala").build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        log.debug("updating the customer details");
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        log.debug("deleting the customer details");
    }
}
