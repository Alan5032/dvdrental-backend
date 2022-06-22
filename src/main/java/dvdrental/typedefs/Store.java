package dvdrental.typedefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = ("store"))
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long storeId;
    @Column(name = "manager_staff_id")
    private Long managerId;
    @Column(name = "address_id")
    private Long addressId;

    public Store() {
    }

    public Store(Long storeId, Long managerId, Long addressId) {
        this.storeId = storeId;
        this.managerId = managerId;
        this.addressId = addressId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getStoreId() {
        return this.storeId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Long getManagerId() {
        return this.managerId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getAddressId() {
        return this.addressId;
    }
}
