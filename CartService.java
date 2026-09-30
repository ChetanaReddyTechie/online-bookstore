package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.CartItem;
import com.example.bookstore.model.CartResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CartService {
    private final ConcurrentHashMap<String, List<CartItem>> carts = new ConcurrentHashMap<>();
    private final BookService bookService;
    private final AtomicLong guestCounter = new AtomicLong(1000);

    public CartService(BookService bookService) {
        this.bookService = bookService;
    }

    public String createCartId() {
        return "guest-" + guestCounter.incrementAndGet();
    }

    private List<CartItem> getItems(String cartId) {
        return carts.computeIfAbsent(cartId, k -> new ArrayList<>());
    }

    public CartResponse getCart(String cartId) {
        List<CartItem> items = getItems(cartId);
        double total = items.stream().mapToDouble(CartItem::getSubtotal).sum();
        return new CartResponse(items, total);
    }

    public CartResponse addToCart(String cartId, Long bookId) {
        Book book = bookService.getBook(bookId);
        if (book == null) throw new IllegalArgumentException("Book not found");

        List<CartItem> items = getItems(cartId);
        synchronized (items) {
            for (CartItem item : items) {
                if (item.getBook().getId().equals(bookId)) {
                    item.setQuantity(item.getQuantity() + 1);
                    return getCart(cartId);
                }
            }
            items.add(new CartItem(book, 1));
        }
        return getCart(cartId);
    }

    public CartResponse removeFromCart(String cartId, Long bookId) {
        List<CartItem> items = getItems(cartId);
        synchronized (items) {
            items.removeIf(item -> item.getBook().getId().equals(bookId));
        }
        return getCart(cartId);
    }

    public void clear(String cartId) {
        carts.remove(cartId);
    }
}
