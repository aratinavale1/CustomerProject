package com.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
import com.customer.repository.CustomerRepository;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerById(Long id) {
        return (Optional<Customer>) customerRepository.findById(id);
    }

    public Page<Customer> getAllCustomers(Pageable pageable) {
        return (Page<Customer>) customerRepository.findAll(pageable);
    }
    public Page<Customer> searchCustomers(String keyword, Pageable pageable) {
        return customerRepository.findByFirstNameContainingOrLastNameContainingOrEmailContainingOrCityContainingOrPhoneContaining(
                keyword, keyword, keyword, keyword, keyword, pageable);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
