package dvdrental.services;

import dvdrental.typedefs.Staff;
import dvdrental.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StaffService extends DVDService<Staff, StaffRepository> {

    @Autowired
    public StaffService(StaffRepository staffRepository) {
        super(staffRepository);
    }

    @Transactional
    public void updateStaff(Long staffId, String firstName, String lastName, Long addressId, String email, Long storeId,
                            String username, String password) {
        Staff staff = repo.findById(staffId).orElseThrow(
                () -> new IllegalArgumentException("No staff with such id.")
        );
        if (firstName != null && firstName.length() > 0) {
            staff.setFirstName(firstName);
        }
        if (lastName != null && lastName.length() > 0) {
            staff.setLastName(lastName);
        }
        if (addressId != null) {
            staff.setAddressId(addressId);
        }
        if (email != null) {
            staff.setEmail(email);
        }
        if (storeId != null) {
            staff.setStoreId(storeId);
        }
        if (username != null && username.length() > 0) {
            staff.setUsername(username);
        }
        if (password != null && password.length() > 0) {
            staff.setPassword(password);
        }
    }
}
