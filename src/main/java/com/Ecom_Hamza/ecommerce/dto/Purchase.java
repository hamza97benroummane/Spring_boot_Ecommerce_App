package com.Ecom_Hamza.ecommerce.dto;

import com.Ecom_Hamza.ecommerce.entity.Address;
import com.Ecom_Hamza.ecommerce.entity.Customer;
import com.Ecom_Hamza.ecommerce.entity.Order;
import com.Ecom_Hamza.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
