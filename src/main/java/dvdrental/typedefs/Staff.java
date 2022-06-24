package dvdrental.typedefs;

import javax.persistence.*;

@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Long staffId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address_id")
    private Long addressId;
    @Column(name = "email")
    private String email;
    @Column(name = "store_id")
    private Long storeId;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    public Staff() {
    }

    public Staff(Long staffId, String firstName, String lastName, Long addressId, String email, Long storeId,
                 String username, String password) {
        this.staffId = staffId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressId = addressId;
        this.email = email;
        this.storeId = storeId;
        this.username = username;
        this.password = password;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public long getStaffId() {
        return this.staffId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getAddressId() {
        return this.addressId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getStoreId() {
        return this.storeId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }
}