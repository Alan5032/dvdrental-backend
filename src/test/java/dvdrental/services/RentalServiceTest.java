package dvdrental.services;

import dvdrental.repositories.RentalRepository;
import dvdrental.typedefs.Rental;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class RentalServiceTest {

    @Mock
    private RentalRepository repo;

    @InjectMocks
    private RentalService service;

    private List<Rental> rentals;

    private OffsetDateTime time = OffsetDateTime.now(ZoneId.systemDefault());

    @BeforeEach
    void beforeEach() {
        rentals = new ArrayList<>();

        rentals.add(new Rental(time, 88888L, 77777L, time, 66666L));
        rentals.add(new Rental(time, 2L, 3L, time, 4L));
    }

    @Test
    void getAll() {
        Mockito.when(repo.findAll()).thenReturn(rentals);

        service.getAll();
        Mockito.verify(repo).findAll();
        assertEquals(rentals, service.getAll());
    }

    @Test
    void get() {
        Mockito.when(repo.findById(1L)).thenReturn(Optional.ofNullable(rentals.get(1)));

        service.get(1L);

        Mockito.verify(repo).findById(1L);
        assertEquals(rentals.get(1), service.get(1L));
        assertThrows(IllegalArgumentException.class, () -> service.get(0L));
    }

    @Test
    void add() {
        service.add(rentals.get(1));
        Mockito.verify(repo).save(rentals.get(1));
    }

    @Test
    void delete() {
        assertThrows(IllegalArgumentException.class, () -> service.delete(0L));
        Mockito.verify(repo).existsById(0L);
    }

    @Test
    void update() {
        Mockito.when(repo.findById(1L)).thenReturn(Optional.ofNullable(rentals.get(1)));

        service.update(1L, time, 1L, 1L, time, 1L);

        assertThrows(IllegalArgumentException.class, () ->service.update(0L, null, null, null, null, null));
        Mockito.verify(repo).findById(1L);
        assertEquals(1L, service.get(1L).getCustomerId());
    }
}
