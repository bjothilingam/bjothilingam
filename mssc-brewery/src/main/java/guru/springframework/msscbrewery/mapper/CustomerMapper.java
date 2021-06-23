package guru.springframework.msscbrewery.mapper;

import guru.springframework.msscbrewery.domain.Customer;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerFromCustomerDto(CustomerDto customerDto);
    CustomerDto customerDtoFromCustomer(Customer customer);
}
