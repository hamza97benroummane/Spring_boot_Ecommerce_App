package com.Ecom_Hamza.ecommerce.service;

import com.Ecom_Hamza.ecommerce.dto.Purchase;
import com.Ecom_Hamza.ecommerce.dto.PurchaseResonse;

public interface CheckoutService {

    PurchaseResonse placeOrder(Purchase purchase);

}
