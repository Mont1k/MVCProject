package peaksoft.repository.impl;


import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Agency;
import peaksoft.entity.Booking;
import peaksoft.repository.BookingRepository;

import java.util.List;

@Repository
@Transactional
public class BookingRepositoryImpl implements BookingRepository {
    private final EntityManager entityManager;
    @Autowired
    public BookingRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void saveBooking(Booking booking) {
        entityManager.persist(booking);
    }

    @Override
    public List<Booking> getAllBooking() {
        return entityManager.createQuery("select b from Booking b order by b.id desc ", Booking.class).getResultList();
    }

    @Override
    public List<Booking> getAllHouse() {
        return entityManager.createQuery("from Booking b ",Booking.class).getResultList();
    }

    @Override
    public Booking getBookingById(Long id) {
        return entityManager.find(Booking.class, id);
    }

    @Override
    public void updateBooking(Long id, Booking booking) {
        Booking booking1 = entityManager.find(Booking.class, id);
        booking1.setHouse(booking.getHouse());
        booking1.setCustomer(booking.getCustomer());
        entityManager.merge(booking1);
    }

    @Override
    public void deleteBookingById(Long id) {
        entityManager.remove(entityManager.find(Booking.class, id));
    }
}
