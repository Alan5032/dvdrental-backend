package dvdrental.services;

import dvdrental.repositories.StoreRepository;
import dvdrental.typedefs.Store;
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
public class StoreServiceTest {

    @Mock
    private StoreRepository repo;

    @InjectMocks
    private StoreService service;

    private List<Store> customers;

    @BeforeEach
    void beforeEach() {
        customers = new ArrayList<>();
        customers.add(new Store(99999L, 88888L, 77777L));
        customers.add(new Store(1L, 2L, 3L));
    }

    @Test
    void getAll() {
        Mockito.when(repo.findAll()).thenReturn(customers);

        service.getAll();
        Mockito.verify(repo).findAll();
        assertEquals(customers, service.getAll());
    }

    @Test
    void get() {
        Mockito.when(repo.findById(1L)).thenReturn(Optional.ofNullable(customers.get(1)));

        service.get(1L);

        Mockito.verify(repo).findById(1L);
        assertEquals(customers.get(1), service.get(1L));
        assertThrows(IllegalArgumentException.class, () -> service.get(0L));
    }

    @Test
    void add() {
        service.add(customers.get(1));
        Mockito.verify(repo).save(customers.get(1));
    }

    @Test
    void delete() {
        assertThrows(IllegalArgumentException.class, () -> service.delete(0L));
        Mockito.verify(repo).existsById(0L);
    }

    @Test
    void update() {
        Mockito.when(repo.findById(1L)).thenReturn(Optional.ofNullable(customers.get(1)));

        service.update(1L, 1L, 1L);

        assertThrows(IllegalArgumentException.class, () ->service.update(0L, null, null));
        Mockito.verify(repo).findById(1L);
        assertEquals(1L, service.get(1L).getAddressId());
    }
}
