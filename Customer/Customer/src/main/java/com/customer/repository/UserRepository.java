package com.customer.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}