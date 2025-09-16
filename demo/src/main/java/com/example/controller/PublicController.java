package com.railway.controller;

import com.railway.model.Booking;
import com.railway.service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PublicController {
    private final BookingService bookingService;
    public PublicController(BookingService bookingService) { this.bookingService = bookingService; }

    @GetMapping({"/", "/index"})
    public String index() { return "index"; }

    @GetMapping("/trains")
    public String trains() { return "trains"; }

    @GetMapping("/booking")
    public String bookingForm() { return "booking"; }

    @PostMapping("/booking")
    public String bookTicket(@RequestParam String trainName, @RequestParam int quantity,
                             @RequestParam String customerName, Model model) {
        Booking b = new Booking(trainName, quantity, customerName);
        bookingService.save(b);
        model.addAttribute("booking", b);
        return "booking_status";
    }
}
