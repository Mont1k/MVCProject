package peaksoft.repository;

import peaksoft.entity.Agency;
import peaksoft.entity.Booking;

import java.util.List;

public interface BookingRepository {
    void saveBooking(Booking booking);

    List<Booking> getAllBooking();

    List<Booking> getAllHouse();

    Booking getBookingById(Long id);

    void updateBooking(Long id, Booking booking);

    void deleteBookingById(Long id);
}
