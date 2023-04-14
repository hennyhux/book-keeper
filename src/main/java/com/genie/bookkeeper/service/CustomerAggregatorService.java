package com.genie.bookkeeper.service;

import com.genie.bookkeeper.entity.Customer;
import com.genie.bookkeeper.scribe.ActivityScribe;
import com.genie.bookkeeper.scribe.ActivityScribeLoggingLevels;
import com.genie.bookkeeper.service.CustomerService.CustomerEntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerAggregatorService {

    @Autowired
    private ActivityScribe activityScribe;

    @Autowired
    private CustomerEntityServiceImpl customerEntityService;

    public void logAllCustomers(){
        activityScribe.logEntry(this.getClass(), customerEntityService.getAllCustomers().get(0).getCustomerName(), ActivityScribeLoggingLevels.INFO);
    }

    public void addCustomer(String Id, String name){
        customerEntityService.insertIntoCustomerDB(name, Id);
    }


}
