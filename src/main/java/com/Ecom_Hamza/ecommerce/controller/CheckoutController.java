package com.Ecom_Hamza.ecommerce.controller;

import com.Ecom_Hamza.ecommerce.dto.Purchase;
import com.Ecom_Hamza.ecommerce.dto.PurchaseResonse;
import com.Ecom_Hamza.ecommerce.service.CheckoutService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    private CheckoutService checkoutService;
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }
    @PostMapping("/purchase")
    public PurchaseResonse placeOrder(@RequestBody Purchase purchase){
        PurchaseResonse purchaseResponse = checkoutService.placeOrder(purchase);
        return purchaseResponse;
    }

}
