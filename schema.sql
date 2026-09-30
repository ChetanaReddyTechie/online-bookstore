CREATE DATABASE IF NOT EXISTS online_bookstore;
USE online_bookstore;

CREATE TABLE books (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    author VARCHAR(150) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    description TEXT,
    image_url VARCHAR(500)
);

CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(200) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL
);

CREATE TABLE orders (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(100) NOT NULL,
    email VARCHAR(200) NOT NULL,
    address TEXT NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE order_items (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    order_id BIGINT NOT NULL,
    book_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (book_id) REFERENCES books(id)
);

CREATE TABLE reviews (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    book_id BIGINT NOT NULL,
    name VARCHAR(100) NOT NULL,
    rating INT NOT NULL,
    comment TEXT NOT NULL,
    FOREIGN KEY (book_id) REFERENCES books(id)
);

INSERT INTO books(title, author, price, description, image_url) VALUES
('Atomic Habits', 'James Clear', 499,
 'A practical guide to building good habits and breaking bad ones.',
 'https://covers.openlibrary.org/b/title/Atomic%20Habits-L.jpg'),
('The Alchemist', 'Paulo Coelho', 299,
 'A young shepherd follows his dreams and discovers the meaning of life.',
 'https://covers.openlibrary.org/b/title/The%20Alchemist-L.jpg'),
('Clean Code', 'Robert C. Martin', 699,
 'A practical handbook of agile software craftsmanship and readable code.',
 'https://covers.openlibrary.org/b/title/Clean%20Code-L.jpg'),
('Rich Dad Poor Dad', 'Robert Kiyosaki', 399,
 'A personal-finance classic about money, investing and financial education.',
 'https://covers.openlibrary.org/b/title/Rich%20Dad%20Poor%20Dad-L.jpg'),
('Ikigai', 'Hector Garcia', 349,
 'A simple introduction to the Japanese concept of purpose and a meaningful life.',
 'https://covers.openlibrary.org/b/title/Ikigai-L.jpg'),
('Think Like a Monk', 'Jay Shetty', 449,
 'Lessons on purpose, resilience, relationships and mindfulness.',
 'https://covers.openlibrary.org/b/title/Think%20Like%20a%20Monk-L.jpg');
