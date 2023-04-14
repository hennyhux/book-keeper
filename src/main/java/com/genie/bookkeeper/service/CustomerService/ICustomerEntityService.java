package com.genie.bookkeeper.service.CustomerService;

import com.genie.bookkeeper.entity.Customer;

import java.util.List;

public interface ICustomerEntityService {

    List<Customer> getAllCustomers();

    void insertIntoCustomerDB(String name, String Id);

}
