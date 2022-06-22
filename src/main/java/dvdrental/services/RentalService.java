package dvdrental.services;

import dvdrental.typedefs.Rental;
import dvdrental.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

import javax.transaction.Transactional;

@Service
public class RentalService extends DVDService<Rental, RentalRepository> {

    @Autowired
    public RentalService(RentalRepository rentalRepository) {
        super(rentalRepository);
    }

    @Transactional
    public void update(Long rentalId, OffsetDateTime rentalDate, Long inventoryId, Long customerId,
                       OffsetDateTime returnDate, Long staffId) {
        Rental rental = repo.findById(rentalId).orElseThrow(
                () -> new IllegalArgumentException("No rental with such id.")
        );
        if (rentalDate != null) {
            rental.setRentalDate(rentalDate);
        }
        if (inventoryId != null) {
            rental.setInventoryId(inventoryId);
        }
        if (customerId != null) {
            rental.setCustomerId(customerId);
        }
        if (returnDate != null) {
            rental.setRentalDate(rentalDate);
        }
        if (staffId != null) {
            rental.setStaffId(staffId);
        }
    }
}
