package peaksoft.repository.impl;

import peaksoft.entity.Customer;
import peaksoft.repository.CustomerRepository;

import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public void saveCustomer(Customer customer) {

    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public void updateCustomer(Long customerId, Customer customer) {

    }

    @Override
    public void deleteCustomerByID(Long customerId) {

    }

    @Override
    public void assignCustomerToAgency(Long customerId, Long agencyId) {

    }
}
