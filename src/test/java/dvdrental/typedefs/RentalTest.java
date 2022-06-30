package dvdrental.typedefs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalTest {

    private final Long inventoryId = 99999L;
    private final Long customerId = 77777L;
    private final Long staffId = 66666L;
    private final OffsetDateTime time = OffsetDateTime.now(ZoneId.systemDefault());

    private Rental rental1;
    private Rental rental2;

    @BeforeEach
    void beforeEach() {
        rental1 = new Rental();
        rental2 = new Rental(time, inventoryId, customerId, time, staffId);
    }

    @Test
    void constructedGetInventoryId() {
        assertEquals(inventoryId, rental2.getInventoryId());
    }

    @Test
    void constructedGetCustomerId() {
        assertEquals(customerId, rental2.getCustomerId());
    }

    @Test
    void constructedGetStaffId() {
        assertEquals(staffId, rental2.getStaffId());
    }

    @Test
    void testConstructedGetRentalDate() {
        assertEquals(time, rental2.getRentalDate());
    }

    @Test
    void testConstructedGetReturnDate() {
        assertEquals(time, rental2.getReturnDate());
    }

    @Test
    void setRentalId() {
        Long rentalId = 88888L;
        rental1.setRentalId(rentalId);
        assertEquals(rentalId, rental1.getRentalId());
    }

    @Test
    void setInventoryId() {
        rental1.setInventoryId(inventoryId);
        assertEquals(inventoryId, rental1.getInventoryId());
    }

    @Test
    void setCustomerId() {
        rental1.setCustomerId(customerId);
        assertEquals(customerId, rental1.getCustomerId());
    }

    @Test
    void setStaffId() {
        rental1.setStaffId(staffId);
        assertEquals(staffId, rental1.getStaffId());
    }

    @Test
    void setRentalDate() {
        rental1.setRentalDate(time);
        assertEquals(time, rental1.getRentalDate());
    }

    @Test
    void setReturnDate() {
        rental1.setReturnDate(time);
        assertEquals(time, rental2.getRentalDate());
    }
}

