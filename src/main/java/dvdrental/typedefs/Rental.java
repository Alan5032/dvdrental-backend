package dvdrental.typedefs;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rental_gen")
    @SequenceGenerator(name = "rental_gen", sequenceName = "rental_rental_id_seq", allocationSize = 1)
    @Column(name = "rental_id")
    private Long rentalId;
    @Column(name = "rental_date")
    private OffsetDateTime rentalDate;
    @Column(name = "inventory_id")
    private Long inventoryId;
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "return_date")
    private OffsetDateTime returnDate;
    @Column(name = "staff_id")
    private Long staffId;

    public Rental() {
    }

    public Rental(OffsetDateTime rentalDate, Long inventoryId, Long customerId,
                  OffsetDateTime returnDate, Long staffId) {
        this.rentalDate = rentalDate;
        this.inventoryId = inventoryId;
        this.customerId = customerId;
        this.returnDate = returnDate;
        this.staffId = staffId;
    }

    public void setRentalId(Long rentalId) {
        this.rentalId = rentalId;
    }

    public Long getRentalId() {
        return this.rentalId;
    }

    public void setRentalDate(OffsetDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public OffsetDateTime getRentalDate() {
        return this.rentalDate;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Long getInventoryId() {
        return this.inventoryId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public void setReturnDate(OffsetDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public OffsetDateTime getReturnDate() {
        return this.returnDate;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Long getStaffId() {
        return this.staffId;
    }
}
