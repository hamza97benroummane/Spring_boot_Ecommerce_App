package com.Ecom_Hamza.ecommerce.dao;

import com.Ecom_Hamza.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

//    Customer findByEmail(String email);
//
//    Customer findByFirstNameAndLastName(String firstName, String lastName);

}
