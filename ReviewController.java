package com.example.bookstore.controller;

import com.example.bookstore.model.Review;
import com.example.bookstore.service.ReviewService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@CrossOrigin
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{bookId}")
    public List<Review> getReviews(@PathVariable Long bookId) {
        return reviewService.getByBook(bookId);
    }

    @PostMapping
    public ResponseEntity<?> addReview(@Valid @RequestBody ReviewRequest request) {
        Review review = new Review(null, request.bookId(), request.name(),
                request.rating(), request.comment());
        return ResponseEntity.ok(reviewService.add(review));
    }

    public record ReviewRequest(
            Long bookId,
            @NotBlank String name,
            @Min(1) @Max(5) int rating,
            @NotBlank String comment
    ) {}
}
