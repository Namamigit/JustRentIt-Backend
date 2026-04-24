package com.namami.justrentitbynp.repository;

import com.namami.justrentitbynp.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByOutfit_IdAndEndDateGreaterThanEqualAndStartDateLessThanEqual(
            Long outfitId,
            LocalDate startDate,
            LocalDate endDate
    );
}