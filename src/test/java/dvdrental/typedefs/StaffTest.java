package dvdrental.typedefs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StaffTest {

    private final Long staffId = 99999L;
    private final Long storeId = 1L;
    private final String firstName = "Random";
    private final String lastName = "Person";
    private final String email = "person@email.com";
    private final Long addressId = 1L;
    private final String username = "Username";
    private final String password = "Password";

    private Staff staff1;
    private Staff staff2;

    @BeforeEach
    void beforeEach() {
        staff1 = new Staff();
        staff2 = new Staff(staffId, firstName, lastName, addressId, email, storeId, username, password);
    }

    @Test
    void constructedGetId() {
        assertEquals(staffId, staff2.getStaffId());
    }

    @Test
    void constructedGetStoreId() {
        assertEquals(storeId, staff2.getStoreId());
    }

    @Test
    void constructedGetFirstName() {
        assertEquals(firstName, staff2.getFirstName());
    }

    @Test
    void constructedGetLastName() {
        assertEquals(lastName, staff2.getLastName());
    }

    @Test
    void constructedGetEmail() {
        assertEquals(email, staff2.getEmail());
    }

    @Test
    void constructedGetAddressId() {
        assertEquals(addressId, staff2.getAddressId());
    }

    @Test
    void constructedGetUsername() {
        assertEquals(username, staff2.getUsername());
    }

    @Test
    void constructedGetPassword() {
        assertEquals(password, staff2.getPassword());
    }

    @Test
    void setStaffId() {
        staff1.setStaffId(staffId);
        assertEquals(staffId, staff1.getStaffId());
    }

    @Test
    void setStoreId() {
        staff1.setStoreId(storeId);
        assertEquals(storeId, staff1.getStoreId());
    }

    @Test
    void setFirstName() {
        staff2.setFirstName("TEST");
        assertEquals("TEST", staff2.getFirstName());
    }

    @Test
    void setLastName() {
        staff2.setLastName("NAME");
        assertEquals("NAME", staff2.getLastName());
    }

    @Test
    void setEmail() {
        staff2.setEmail("email");
        assertEquals("email", staff2.getEmail());
    }

    @Test
    void setAddressId() {
        staff1.setAddressId(99899L);
        assertEquals(99899L, staff1.getAddressId());
    }

    @Test
    void setUsername() {
        staff1.setUsername(username);
        assertEquals(username, staff1.getUsername());
    }

    @Test
    void setPassword() {
        staff2.setPassword(password);
        assertEquals(password, staff2.getPassword());
    }
}
