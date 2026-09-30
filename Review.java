package com.example.bookstore.model;

public class Review {
    private Long id;
    private Long bookId;
    private String name;
    private int rating;
    private String comment;

    public Review() {}

    public Review(Long id, Long bookId, String name, int rating, String comment) {
        this.id = id;
        this.bookId = bookId;
        this.name = name;
        this.rating = rating;
        this.comment = comment;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getBookId() { return bookId; }
    public void setBookId(Long bookId) { this.bookId = bookId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}
