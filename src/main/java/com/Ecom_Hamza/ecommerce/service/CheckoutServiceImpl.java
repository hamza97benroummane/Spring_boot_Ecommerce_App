package com.Ecom_Hamza.ecommerce.service;

import com.Ecom_Hamza.ecommerce.dao.CustomerRepository;
import com.Ecom_Hamza.ecommerce.dto.Purchase;
import com.Ecom_Hamza.ecommerce.dto.PurchaseResonse;
import com.Ecom_Hamza.ecommerce.entity.Customer;
import com.Ecom_Hamza.ecommerce.entity.Order;
import com.Ecom_Hamza.ecommerce.entity.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    @Transactional
    public PurchaseResonse placeOrder(Purchase purchase) {

        //retrieve the order info from dto
        Order order = purchase.getOrder();

        //generate tracking number for the order
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        //populate customer
        Customer customer = purchase.getCustomer();
        customer.add(order);

        //save to the database

        customerRepository.save(customer);

        return new PurchaseResonse(orderTrackingNumber);

    }

    private String generateOrderTrackingNumber() {

        //generate a random UUID number (UUID version-4)
        return UUID.randomUUID().toString();
    }
}
