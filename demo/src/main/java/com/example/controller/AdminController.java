package com.railway.controller;

import com.railway.model.Booking;
import com.railway.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final BookingService bookingService;
    public AdminController(BookingService bookingService) { this.bookingService = bookingService; }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("bookings", bookingService.pending());
        return "admin_dashboard";
    }

    @PostMapping("/bookings/{id}/confirm")
    @ResponseBody
    public ResponseEntity<?> confirmBooking(@PathVariable Long id) {
        return bookingService.find(id).map(b -> {
            b.setConfirmed(true);
            bookingService.save(b);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
