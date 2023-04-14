package com.genie.bookkeeper.repo;

import com.genie.bookkeeper.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer, Integer> {

    List<Customer> findAll();

    Customer findCustomerByCustomerName(String customerName);

}