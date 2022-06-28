package dvdrental.typedefs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    private final Long customerId = 99999L;
    private final Long storeId = 1L;
    private final String firstName = "Random";
    private final String lastName = "Person";
    private final String email = "person@email.com";
    private final Long addressId = 1L;

    private Customer customer1;
    private Customer customer2;

    @BeforeEach
    void beforeEach() {
        customer1 = new Customer();
        customer2 = new Customer(customerId, storeId, firstName, lastName, email, addressId);
    }

    @Test
    void constructedGetId() {
        assertEquals(customerId, customer2.getCustomerId());
    }

    @Test
    void constructedGetStoreId() {
        assertEquals(storeId, customer2.getStoreId());
    }

    @Test
    void constructedGetFirstName() {
        assertEquals(firstName, customer2.getFirstName());
    }

    @Test
    void constructedGetLastName() {
        assertEquals(lastName, customer2.getLastName());
    }

    @Test
    void constructedGetEmail() {
        assertEquals(email, customer2.getEmail());
    }

    @Test
    void constructedGetAddressId() {
        assertEquals(addressId, customer2.getAddressId());
    }

    @Test
    void setCustomerId() {
        customer1.setCustomerId(customerId);
        assertEquals(customerId, customer1.getCustomerId());
    }

    @Test
    void setStoreId() {
        customer1.setStoreId(storeId);
        assertEquals(storeId, customer1.getStoreId());
    }

    @Test
    void setFirstName() {
        customer2.setFirstName("TEST");
        assertEquals("TEST", customer2.getFirstName());
    }

    @Test
    void setLastName() {
        customer2.setLastName("NAME");
        assertEquals("NAME", customer2.getLastName());
    }

    @Test
    void setEmail() {
        customer2.setEmail("email");
        assertEquals("email", customer2.getEmail());
    }

    @Test
    void setAddressId() {
        customer1.setAddressId(99899L);
        assertEquals(99899L, customer1.getAddressId());
    }
}

