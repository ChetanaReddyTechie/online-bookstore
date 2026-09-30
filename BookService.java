package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();

    public BookService() {
        books.add(new Book(1L, "Atomic Habits", "James Clear", 499,
                "A practical guide to building good habits and breaking bad ones.",
                "https://covers.openlibrary.org/b/title/Atomic%20Habits-L.jpg"));
        books.add(new Book(2L, "The Alchemist", "Paulo Coelho", 299,
                "A young shepherd follows his dreams and discovers the meaning of life.",
                "https://covers.openlibrary.org/b/title/The%20Alchemist-L.jpg"));
        books.add(new Book(3L, "Clean Code", "Robert C. Martin", 699,
                "A practical handbook of agile software craftsmanship and readable code.",
                "https://covers.openlibrary.org/b/title/Clean%20Code-L.jpg"));
        books.add(new Book(4L, "Rich Dad Poor Dad", "Robert Kiyosaki", 399,
                "A personal-finance classic about money, investing and financial education.",
                "https://covers.openlibrary.org/b/title/Rich%20Dad%20Poor%20Dad-L.jpg"));
        books.add(new Book(5L, "Ikigai", "Hector Garcia", 349,
                "A simple introduction to the Japanese concept of purpose and a meaningful life.",
                "https://covers.openlibrary.org/b/title/Ikigai-L.jpg"));
        books.add(new Book(6L, "Think Like a Monk", "Jay Shetty", 449,
                "Lessons on purpose, resilience, relationships and mindfulness.",
                "https://covers.openlibrary.org/b/title/Think%20Like%20a%20Monk-L.jpg"));
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public List<Book> search(String query) {
        if (query == null || query.isBlank()) return getAllBooks();
        String q = query.toLowerCase();
        return books.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(q)
                        || b.getAuthor().toLowerCase().contains(q))
                .toList();
    }

    public Book getBook(Long id) {
        return books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
