package dvdrental.services;

import dvdrental.repositories.StaffRepository;
import dvdrental.typedefs.Staff;
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
public class StaffServiceTest {

    @Mock
    private StaffRepository repo;

    @InjectMocks
    private StaffService service;

    private List<Staff> staffs;

    @BeforeEach
    void beforeEach() {
        staffs = new ArrayList<>();
        staffs.add(new Staff(99999L, "First", "Last", 88888L, "email", 77777L, "username", "password"));
        staffs.add(new Staff(1L, "Bob", "Jones", 2L, "email.com", 3L, "user", "pass"));
    }

    @Test
    void getAll() {
        Mockito.when(repo.findAll()).thenReturn(staffs);

        service.getAll();
        Mockito.verify(repo).findAll();
        assertEquals(staffs, service.getAll());
    }

    @Test
    void get() {
        Mockito.when(repo.findById(1L)).thenReturn(Optional.ofNullable(staffs.get(1)));

        service.get(1L);

        Mockito.verify(repo).findById(1L);
        assertEquals(staffs.get(1), service.get(1L));
        assertThrows(IllegalArgumentException.class, () -> service.get(0L));
    }

    @Test
    void add() {
        service.add(staffs.get(1));
        Mockito.verify(repo).save(staffs.get(1));
    }

    @Test
    void delete() {
        assertThrows(IllegalArgumentException.class, () -> service.delete(0L));
        Mockito.verify(repo).existsById(0L);
    }

    @Test
    void update() {
        Mockito.when(repo.findById(1L)).thenReturn(Optional.ofNullable(staffs.get(1)));

        service.update(1L, "New", "Name", 1L, "name@email.com", 1L, "userName", "passWord");

        assertThrows(IllegalArgumentException.class, () ->service.update(0L, null, null, null, null, null, null, null));
        Mockito.verify(repo).findById(1L);
        assertEquals("New", service.get(1L).getFirstName());
    }
}
