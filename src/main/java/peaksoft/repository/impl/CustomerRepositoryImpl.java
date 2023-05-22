package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Agency;
import peaksoft.entity.Customer;
import peaksoft.repository.CustomerRepository;

import java.util.List;
@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    private final EntityManager entityManager;
    @Autowired
    public CustomerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return entityManager.find(Customer.class,id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return entityManager.createQuery("select c from Customer c",Customer.class).getResultList();
    }

    @Override
    public void updateCustomer(Long id, Customer customer) {
        Customer customer1 = entityManager.find(Customer.class, id);
        customer1.setName(customer.getName());
        customer1.setSurName(customer.getSurName());
        customer1.setEmail(customer.getEmail());
        customer1.setGender(customer.getGender());
        customer1.setPhoneNumber(customer.getPhoneNumber());
        customer1.setDateOfBirth(customer.getDateOfBirth());
        entityManager.merge(customer1);
    }

    @Override
    public void deleteCustomerByID(Long id) {
        entityManager.remove(entityManager.find(Customer.class,id));
    }

    @Override
    public void assignCustomerToAgency(Long customerId, Long agencyId) {
        Customer customer = entityManager.find(Customer.class, customerId);
        Agency agency = entityManager.find(Agency.class, agencyId);
        customer.getAgencies().add(agency);
        agency.getCustomers().add(customer);
        entityManager.persist(customer);
    }
}
