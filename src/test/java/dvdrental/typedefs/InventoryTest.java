package dvdrental.typedefs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryTest {

    private final Long filmId = 99999L;
    private final String filmTitle = "amazing name";
    private final Long storeId = 77777L;

    private Inventory inventory1;
    private Inventory inventory2;

    @BeforeEach
    void beforeEach() {
        inventory1 = new Inventory();
        inventory2 = new Inventory(filmId, storeId);
    }

    @Test
    void constructedGetFilmId() {
        assertEquals(filmId, inventory2.getFilmId());
    }

    @Test
    void constructedGetFilmTitle() {
        inventory2.setFilmTitle(filmTitle);
        assertEquals(filmTitle, inventory2.getFilmTitle());
    }

    @Test
    void constructedGetStoreId() {
        assertEquals(storeId, inventory2.getStoreId());
    }

    @Test
    void setInventoryId() {
        Long inventoryId = 88888L;
        inventory1.setInventoryId(inventoryId);
        assertEquals(inventoryId, inventory1.getInventoryId());
    }

    @Test
    void setFilmId() {
        inventory1.setFilmId(filmId);
        assertEquals(filmId, inventory1.getFilmId());
    }

    @Test
    void setFilmTitle() {
        inventory1.setFilmTitle(filmTitle);
        assertEquals(filmTitle, inventory1.getFilmTitle());
    }

    @Test
    void setStoreId() {
        inventory1.setStoreId(storeId);
        assertEquals(storeId, inventory2.getStoreId());
    }
}

