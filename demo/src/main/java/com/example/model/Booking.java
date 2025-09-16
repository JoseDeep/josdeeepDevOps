package com.railway.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String trainName;
    private int quantity;
    private String customerName;
    private boolean confirmed;

    public Booking() {}

    public Booking(String trainName, int quantity, String customerName) {
        this.trainName = trainName;
        this.quantity = quantity;
        this.customerName = customerName;
        this.confirmed = false;
    }
    // Getters and setters
    // ... same as in original
}
