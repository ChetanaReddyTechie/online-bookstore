package com.example.bookstore.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class OrderRequest {
    @NotBlank
    private String customerName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String address;

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
