package dvdrental.services;

import dvdrental.typedefs.Customer;
import dvdrental.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerService extends DVDService<Customer, CustomerRepository> {

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        super(customerRepository);
    }

    @Transactional
    public void update(Long customerId, Long storeId, String firstName, String lastName, String email, Long addressId) {
        Customer customer = repo.findById(customerId).orElseThrow(
                () -> new IllegalArgumentException("No customer with such id.")
        );
        if (storeId != null) {
            customer.setStoreId(storeId);
        }
        if (firstName != null && firstName.length() > 0) {
            customer.setFirstName(firstName);
        }
        if (lastName != null && lastName.length() > 0) {
            customer.setLastName(lastName);
        }
        if (email != null) {
            customer.setEmail(email);
        }
        if (addressId != null) {
            customer.setAddressId(addressId);
        }
    }
}
