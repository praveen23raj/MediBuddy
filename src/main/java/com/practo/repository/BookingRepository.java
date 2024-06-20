package com.practo.repository;

import com.practo.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    Optional<Booking> findByDoctorIdAndSlotTypeAndBookingTimeBetween(
            long doctorId,
            Booking.SlotType slotType,
            LocalDateTime startTime,
            LocalDateTime endTime
    );

}
