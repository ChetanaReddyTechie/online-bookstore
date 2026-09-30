package com.example.bookstore.controller;

import com.example.bookstore.model.CartResponse;
import com.example.bookstore.service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public CartResponse getCart(@RequestParam String cartId) {
        return cartService.getCart(cartId);
    }

    @PostMapping
    public CartResponse addBook(@RequestParam String cartId,
                                @RequestParam Long bookId) {
        return cartService.addToCart(cartId, bookId);
    }

    @DeleteMapping("/{id}")
    public CartResponse removeBook(@RequestParam String cartId,
                                   @PathVariable Long id) {
        return cartService.removeFromCart(cartId, id);
    }
}
