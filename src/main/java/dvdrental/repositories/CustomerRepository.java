package dvdrental.repositories;

import dvdrental.typedefs.Customer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
