package com.example.bookstore.service;

import com.example.bookstore.model.Review;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ReviewService {
    private final List<Review> reviews = new ArrayList<>();
    private final AtomicLong id = new AtomicLong(0);

    public ReviewService() {
        reviews.add(new Review(id.incrementAndGet(), 1L, "Chetana", 5,
                "Very useful book. Easy to understand."));
        reviews.add(new Review(id.incrementAndGet(), 3L, "Student", 5,
                "Helpful for learning clean coding practices."));
    }

    public List<Review> getByBook(Long bookId) {
        return reviews.stream().filter(r -> r.getBookId().equals(bookId)).toList();
    }

    public Review add(Review review) {
        review.setId(id.incrementAndGet());
        reviews.add(review);
        return review;
    }
}
