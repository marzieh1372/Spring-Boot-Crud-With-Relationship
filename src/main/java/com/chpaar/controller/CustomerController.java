package com.chpaar.controller;

import com.chpaar.api.CustomerAPI;
import com.chpaar.model.dto.CustomerRequest;
import com.chpaar.model.dto.CustomerResponse;
import com.chpaar.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class CustomerController implements CustomerAPI {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public ResponseEntity<List<CustomerResponse>> getAllCustomer() {
        return new ResponseEntity<List<CustomerResponse>>(customerService.getAllCustomer(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CustomerResponse> createCustomer(CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerService.saveCustomer(customerRequest);
        return new ResponseEntity<CustomerResponse>(customerResponse,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CustomerResponse> getCustomerById(Long customerId) {
        return new ResponseEntity<CustomerResponse>(customerService.getCustomerById(customerId),HttpStatus.OK);
    }

    @Override
    public ResponseEntity updateCustomer(Long customerId, CustomerRequest customerRequest) {
        customerService.updateCustomer(customerId,customerRequest);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity deleteCustomer(Long customerId) {
        customerService.deleteCustomerById(customerId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
