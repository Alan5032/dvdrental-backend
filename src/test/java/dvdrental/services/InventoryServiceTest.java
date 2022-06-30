package dvdrental.services;

import dvdrental.repositories.FilmRepository;
import dvdrental.repositories.InventoryRepository;
import dvdrental.typedefs.Film;
import dvdrental.typedefs.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class InventoryServiceTest {

    @Mock
    private InventoryRepository invRepo;

    @Mock
    private FilmRepository filmRepo;

    @InjectMocks
    private InventoryService service;

    private List<Inventory> inventories;

    @BeforeEach
    void beforeEach() {
        inventories = new ArrayList<>();
        inventories.add(new Inventory(88888L, 77777L));
        inventories.add(new Inventory(2L, 3L));
    }

    @Test
    void getAll() {
        Mockito.when(invRepo.findAll()).thenReturn(inventories);
        Mockito.when(filmRepo.findById(88888L)).thenReturn(Optional.of(new Film("New Film")));
        Mockito.when(filmRepo.findById(2L)).thenReturn(Optional.of(new Film("Old Film")));

        service.getAll();

        Mockito.verify(invRepo).findAll();
        Mockito.verify(filmRepo).findById(88888L);
        Mockito.verify(filmRepo).findById(2L);
        assertEquals(inventories, service.getAll());
        assertEquals("New Film", service.getAll().get(0).getFilmTitle());
    }

    @Test
    void get() {
        Mockito.when(invRepo.findById(1L)).thenReturn(Optional.ofNullable(inventories.get(1)));
        Mockito.when(filmRepo.findById(2L)).thenReturn(Optional.of(new Film("Old Film")));

        service.get(1L);

        Mockito.verify(invRepo).findById(1L);
        Mockito.verify(filmRepo).findById(2L);
        assertEquals(inventories.get(1), service.get(1L));
        assertEquals("Old Film", service.get(1L).getFilmTitle());
        assertThrows(IllegalArgumentException.class, () -> service.get(0L));
    }

    @Test
    void add() {
        service.add(inventories.get(1));
        Mockito.verify(invRepo).save(inventories.get(1));
    }

    @Test
    void delete() {
        assertThrows(IllegalArgumentException.class, () -> service.delete(0L));
        Mockito.verify(invRepo).existsById(0L);
    }

    @Test
    void update() {
        Mockito.when(invRepo.findById(1L)).thenReturn(Optional.ofNullable(inventories.get(1)));
        Mockito.when(filmRepo.findById(1L)).thenReturn(Optional.of(new Film("Old Film")));

        service.update(1L, 1L, "Old Film", 1L);

        assertThrows(IllegalArgumentException.class, () -> service.update(0L, null, null, null));
        Mockito.verify(invRepo).findById(1L);
        assertEquals("Old Film", service.get(1L).getFilmTitle());
    }
}
