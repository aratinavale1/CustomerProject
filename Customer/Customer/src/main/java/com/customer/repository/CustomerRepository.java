package com.customer.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.entity.Customer;



@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findByFirstNameContainingOrLastNameContainingOrEmailContainingOrCityContainingOrPhoneContaining(
            String firstName, String lastName, String email, String city, String phone, Pageable pageable);
}