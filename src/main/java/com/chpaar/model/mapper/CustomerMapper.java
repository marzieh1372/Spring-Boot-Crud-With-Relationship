package com.chpaar.model.mapper;

import com.chpaar.model.dto.CustomerRequest;
import com.chpaar.model.dto.CustomerResponse;
import com.chpaar.model.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CustomerMapper {

    public abstract Customer mapCustomerRequestToCustomer(CustomerRequest customerRequest);

    public abstract CustomerRequest mapCustomerToCustomerRequest(Customer customer);

    public abstract CustomerResponse mapCustomerToCustomerResponse(Customer customer);

    public abstract List<CustomerResponse> mapCustomerListToCustomerResponse(List<Customer> customers);
}
