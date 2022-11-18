package com.chpaar.service;

import com.chpaar.exceptions.ResourceNotFoundException;
import com.chpaar.model.dto.CustomerRequest;
import com.chpaar.model.dto.CustomerResponse;
import com.chpaar.model.entity.Customer;
import com.chpaar.model.mapper.CustomerMapper;
import com.chpaar.repo.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepo;
    private CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepo,CustomerMapper customerMapper) {
        this.customerRepo = customerRepo;
        this.customerMapper = customerMapper;
    }

    public List<CustomerResponse> getAllCustomer() {
        return customerMapper.mapCustomerListToCustomerResponse(customerRepo.findAll());
    }

    public CustomerResponse saveCustomer(CustomerRequest customerRequest) {
        Customer customer=customerMapper.mapCustomerRequestToCustomer(customerRequest);
        return customerMapper.mapCustomerToCustomerResponse(customerRepo.save(customer));
    }

    public CustomerResponse getCustomerById(Long id) {
        return customerMapper.mapCustomerToCustomerResponse(findById(id));
    }

    private Customer findById(Long id){
        return customerRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("No customer found"));
    }

    //TODO change base on order
    public void deleteCustomerById(Long id) {
        customerRepo.deleteById(id);
    }

    public void updateCustomer(Long customerId, CustomerRequest customerRequest){
        Customer findCustomer = findById(customerId);
        findCustomer.setDescription(customerRequest.getDescription());
        findCustomer.setEmail(customerRequest.getEmail());
        findCustomer.setFirstName(customerRequest.getFirstName());
        findCustomer.setLastName(customerRequest.getLastName());
        customerRepo.save(findCustomer);
    }
}
