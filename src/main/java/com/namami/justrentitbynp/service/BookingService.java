package com.namami.justrentitbynp.service;

import com.namami.justrentitbynp.entity.Booking;
import com.namami.justrentitbynp.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    // CREATE BOOKING (WITH AVAILABILITY CHECK)
    public String createBooking(Booking booking) {

        List<Booking> existingBookings =
                bookingRepository.findByOutfit_IdAndEndDateGreaterThanEqualAndStartDateLessThanEqual(
                        booking.getOutfit().getId(),
                        booking.getStartDate(),
                        booking.getEndDate()
                );

        if (!existingBookings.isEmpty()) {
            return "Outfit already booked for selected dates ❌";
        }

        booking.setPaymentStatus("PAID");

        bookingRepository.save(booking);
        return "Booking successful ✅";
    }

    public String checkAvailability(Long outfitId, String startDate, String endDate) {

        List<Booking> bookings =
                bookingRepository.findByOutfit_IdAndEndDateGreaterThanEqualAndStartDateLessThanEqual(
                        outfitId,
                        java.time.LocalDate.parse(startDate),
                        java.time.LocalDate.parse(endDate)
                );

        if (bookings.isEmpty()) {
            return "Outfit available ✅";
        }

        return "Outfit NOT available ❌";
    }

    // GET ALL BOOKINGS
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}