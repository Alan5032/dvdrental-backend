package dvdrental.typedefs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {

    private final Long managerId = 88888L;
    private final Long addressId = 77777L;

    private Store store1;
    private Store store2;

    @BeforeEach
    void beforeEach() {
        store1 = new Store();
        store2 = new Store(managerId, addressId);
    }

    @Test
    void constructedGetManagerId() {
        assertEquals(managerId, store2.getManagerId());
    }

    @Test
    void constructedGetAddressId() {
        assertEquals(addressId, store2.getAddressId());
    }

    @Test
    void setStoreId() {
        Long storeId = 99999L;
        store1.setStoreId(storeId);
        assertEquals(storeId, store1.getStoreId());
    }

    @Test
    void setManagerId() {
        store1.setManagerId(managerId);
        assertEquals(managerId, store2.getManagerId());
    }

    @Test
    void setAddressId() {
        store1.setAddressId(addressId);
        assertEquals(addressId, store1.getAddressId());
    }
}

