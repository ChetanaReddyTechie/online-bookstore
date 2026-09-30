package com.example.bookstore.controller;

import com.example.bookstore.model.CartResponse;
import com.example.bookstore.model.OrderRequest;
import com.example.bookstore.service.CartService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/checkout")
@CrossOrigin
public class CheckoutController {
    private final CartService cartService;

    public CheckoutController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<?> checkout(@RequestParam String cartId,
                                      @Valid @RequestBody OrderRequest request) {
        CartResponse cart = cartService.getCart(cartId);

        if (cart.getItems().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Your cart is empty."));
        }

        String orderId = "ORD-" + System.currentTimeMillis();
        double total = cart.getTotal();
        cartService.clear(cartId);

        return ResponseEntity.ok(Map.of(
                "message", "Order placed successfully!",
                "orderId", orderId,
                "customerName", request.getCustomerName(),
                "total", total
        ));
    }
}
