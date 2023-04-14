package com.example.bookkeeper.controller;

import com.example.bookkeeper.scribe.ActivityScribe;
import com.example.bookkeeper.scribe.ActivityScribeLoggingLevels;
import com.keeper.openapi.api.CustomersApi;
import com.keeper.openapi.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController implements CustomersApi {

    private final ActivityScribe scribe;

    public CustomerController(ActivityScribe scribe){
        this.scribe = scribe;
    }

    @Override
    public ResponseEntity<Void> createCustomer(){
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        scribe.logEntry(this.getClass(), "Create pets endpoint invoked in controller", ActivityScribeLoggingLevels.INFO);
        return responseEntity;
    }

    @Override
    public ResponseEntity<List<Customer>> listCustomers(Integer limit){
        scribe.logEntry(this.getClass(), "List pets endpoint invoked in controller", ActivityScribeLoggingLevels.INFO);
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<List<Customer>> showCustomerById(String customerId){
        scribe.logEntry(this.getClass(), "Show pets endpoint invoked in controller", ActivityScribeLoggingLevels.INFO);
        return  new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}