package com.namami.justrentitbynp.controller;

import com.namami.justrentitbynp.entity.Booking;
import com.namami.justrentitbynp.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")

@CrossOrigin(origins = "*")

public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public String createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/availability")
    public String checkAvailability(
            @RequestParam Long outfitId,
            @RequestParam String startDate,
            @RequestParam String endDate) {

        return bookingService.checkAvailability(outfitId, startDate, endDate);
    }
}

