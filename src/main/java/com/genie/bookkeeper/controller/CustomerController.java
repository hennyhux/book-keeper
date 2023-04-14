package com.genie.bookkeeper.controller;

import com.genie.bookkeeper.repo.ICustomerRepo;
import com.genie.bookkeeper.scribe.ActivityScribe;
import com.genie.bookkeeper.scribe.ActivityScribeLoggingLevels;
import com.genie.bookkeeper.service.CustomerAggregatorService;
import com.keeper.openapi.api.CustomersApi;

import com.keeper.openapi.model.Customer;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class CustomerController implements CustomersApi {

    private final ActivityScribe scribe;
    private final ICustomerRepo customerRepo;
    private final CustomerAggregatorService customerAggregatorService;

    public CustomerController(ActivityScribe scribe, CustomerAggregatorService customerAggregatorService, ICustomerRepo customerRepo){
        this.scribe = scribe;
        this.customerRepo = customerRepo;
        this.customerAggregatorService = customerAggregatorService;
    }

    @Override
    public ResponseEntity<Void> createCustomer(@ApiParam(value = "A JSON object containing customer info" ,required=true )  @Valid @RequestBody Customer customer) {
        com.genie.bookkeeper.entity.Customer customerEntity = new com.genie.bookkeeper.entity.Customer();
        customerEntity.setCustomerFirstName(customer.getFirstname());
        customerEntity.setCustomerLastName(customer.getLastName());
        customerEntity.setPhoneNumber(customer.getPhoneNumber());
        customerRepo.saveAndFlush(customerEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/customersList")
    public List<com.genie.bookkeeper.entity.Customer> getAllCustomers(){
        return customerRepo.findAll();
    }

    @Override
    public ResponseEntity<List<com.keeper.openapi.model.Customer>> listCustomers(Integer limit){
        scribe.logEntry(this.getClass(), "List pets endpoint invoked in controller", ActivityScribeLoggingLevels.INFO);
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<List<com.keeper.openapi.model.Customer>> showCustomerById(String customerId){
        scribe.logEntry(this.getClass(), "Show pets endpoint invoked in controller", ActivityScribeLoggingLevels.INFO);
        return  new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}