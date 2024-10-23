package com.Ecom_Hamza.ecommerce.dao;

import com.Ecom_Hamza.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
