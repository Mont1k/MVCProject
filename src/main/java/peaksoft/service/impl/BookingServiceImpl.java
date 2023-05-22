package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.entity.Booking;
import peaksoft.repository.BookingRepository;
import peaksoft.service.BookingService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    @Override
    public void saveBooking(Long houseId, Long customerId, Booking booking) {

    }

    @Override
    public List<Booking> getAll() {
        return null;
    }

    @Override
    public Booking getBookingById(Long id) {
        return null;
    }

    @Override
    public void updateBooking(Long id, Booking booking) {

    }

    @Override
    public void deleteBookingById(Long id) {

    }
}
