package com.genie.bookkeeper.controller;

import com.genie.bookkeeper.entity.Customer;
import com.genie.bookkeeper.repo.ICustomerRepo;
import com.genie.bookkeeper.scribe.ActivityScribe;
import com.genie.bookkeeper.scribe.ActivityScribeLoggingLevels;
import com.genie.bookkeeper.service.CustomerAggregatorService;
import com.keeper.openapi.api.CustomersApi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController implements CustomersApi {

    private final ActivityScribe scribe;

    private final ICustomerRepo customerRepo;

    public CustomerController(ActivityScribe scribe, CustomerAggregatorService customerAggregatorService, ICustomerRepo customerRepo){
        this.scribe = scribe;
        this.customerRepo = customerRepo;
    }

    @Override
    public ResponseEntity<Void> createCustomer(){
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        scribe.logEntry(this.getClass(), "Create customer endpoint invoked in controller", ActivityScribeLoggingLevels.INFO);
        return responseEntity;
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

    @GetMapping("/testing")
    public List<Customer> getAllCustomers(){
        customerRepo.save(new Customer("hello", "lil peep"));
        return customerRepo.findAll();
    }
}