package com.genie.bookkeeper.service.CustomerService;

import com.genie.bookkeeper.repo.ICustomerRepo;
import com.genie.bookkeeper.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerEntityServiceImpl implements ICustomerEntityService{

    @Autowired
    private ICustomerRepo customerRepo;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public void insertIntoCustomerDB(String name, String Id){
        Customer customer = new Customer();
        customer.setCustomerName(name);
        customer.setId(UUID.randomUUID().toString().substring(0, 10));
        customerRepo.save(customer);
    }
}
