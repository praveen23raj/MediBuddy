package com.practo.service;

import com.practo.entity.Booking;
import com.practo.repository.BookingRepository;
import com.practo.repository.DoctorRepository;
import com.practo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private PatientRepository patientRepo;

    public Booking createBooking(Booking booking) {
        long doctorId = booking.getDoctorId();
        long patientId = booking.getPatientId();
        LocalDateTime bookingTime = booking.getBookingTime();
        Booking.SlotType slotType = booking.getSlotType();

        if (doctorRepo.existsById(doctorId) && patientRepo.existsById(patientId)) {
            // Calculate the start and end time for the 24-hour window
            LocalDateTime startTime = bookingTime.truncatedTo(ChronoUnit.DAYS);
            LocalDateTime endTime = startTime.plusDays(1).minusSeconds(1);

            // Check if there is any existing booking within the last 24 hours
            Optional<Booking> existingBooking = bookingRepo.findByDoctorIdAndSlotTypeAndBookingTimeBetween(
                    doctorId,
                    slotType,
                    startTime,
                    endTime
            );

            if (existingBooking.isPresent()) {
                throw new IllegalStateException("Slot already booked within last 24 hours");
            } else {
                return bookingRepo.save(booking);
            }
        } else {
            throw new IllegalArgumentException("Doctor or Patient does not exist");
        }
    }

    public Booking getBookingById(long id) {
        return bookingRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Booking not found"));
    }

    public void deleteBooking(long id) {
        if (bookingRepo.existsById(id)) {
            bookingRepo.deleteById(id);
        } else {
            throw new IllegalArgumentException("Booking not found");
        }
    }
}
