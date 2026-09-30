package com.example.bookstore.controller;

import com.example.bookstore.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/session")
@CrossOrigin
public class CartIdController {
    private final CartService cartService;

    public CartIdController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/cart")
    public Map<String, String> createCart() {
        return Map.of("cartId", cartService.createCartId());
    }
}
