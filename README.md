# Online Bookstore - Full Stack Java Project

## 1. Project objective
A simple online bookstore where users can:
- Browse books
- Search books by title or author
- Open a book details page
- Add books to cart
- Remove books from cart
- Checkout and receive an order confirmation
- Signup/login with basic validation
- Add and view book reviews

## 2. Technology stack
- Frontend: HTML, CSS, JavaScript
- Backend: Java 17, Spring Boot, Spring Web MVC
- Build tool: Maven
- Database: Not required for this starter version (data is stored in memory)
- Optional: JDBC + MySQL can be added later

## 3. Requirements
Install:
1. JDK 17
2. IntelliJ IDEA / Eclipse
3. Maven (or use the Maven wrapper if you add one)

## 4. Run in IntelliJ IDEA
1. Extract the ZIP.
2. Open the `online-bookstore` folder in IntelliJ IDEA.
3. Wait for Maven dependencies to download.
4. Open:
   `src/main/java/com/example/bookstore/OnlineBookstoreApplication.java`
5. Click the green Run button.
6. Open:
   `http://localhost:8080/`

Do NOT open `index.html` directly from the file system. Run Spring Boot first and then use localhost.

## 5. Pages
- `/` -> Home page
- `/book.html?id=1` -> Book details
- `/cart.html` -> Cart
- `/checkout.html` -> Checkout
- `/login.html` -> Login/Signup

## 6. API endpoints
- GET `/books` -> Fetch all books
- GET `/books/{id}` -> Fetch book details
- POST `/cart?cartId=...&bookId=...` -> Add book to cart
- GET `/cart?cartId=...` -> Get user's cart
- DELETE `/cart/{id}?cartId=...` -> Remove book
- POST `/checkout?cartId=...` -> Place order
- GET `/reviews/{bookId}` -> Fetch reviews
- POST `/reviews` -> Add review
- POST `/auth/signup` -> Signup
- POST `/auth/login` -> Login
- POST `/session/cart` -> Create guest cart

## 7. Important note about authentication
This is a college-level starter project. The login/signup example stores passwords in memory and is NOT production security. For a real application, use Spring Security, password hashing, database storage and sessions/JWT.

## 8. Optional MySQL upgrade
The starter version intentionally does not require MySQL so that the project runs easily. If your faculty requires a database, add:
- MySQL Connector/J
- JDBC repository classes
- `application.properties` database URL, username and password
- `books`, `users`, `cart`, `cart_items`, `orders`, and `reviews` tables

A sample schema is included in `database/schema.sql`.

## 9. Suggested viva explanation
Frontend sends HTTP requests using JavaScript `fetch()`.
Spring Boot receives the requests through REST controllers.
Services contain the application logic.
The BookService provides books, CartService manages cart items, and CheckoutController creates an order confirmation.
The frontend displays the JSON responses as HTML cards and tables.

## 10. Project structure
online-bookstore/
├── pom.xml
├── README.md
├── database/
│   └── schema.sql
└── src/main/
    ├── java/com/example/bookstore/
    │   ├── OnlineBookstoreApplication.java
    │   ├── controller/
    │   ├── model/
    │   └── service/
    └── resources/
        ├── application.properties
        └── static/
            ├── index.html
            ├── book.html
            ├── cart.html
            ├── checkout.html
            ├── login.html
            ├── css/style.css
            └── js/app.js
