package dvdrental.typedefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Long inventoryId;
    @Column(name = "film_id")
    private Long filmId;
    @Transient
    private String filmTitle;
    @Column(name = "store_id")
    private Long storeId;

    public Inventory() {
    }

    public Inventory(Long inventoryId, Long filmId, Long storeId) {
        this.inventoryId = inventoryId;
        this.filmId = filmId;
        this.storeId = storeId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Long getInventoryId() {
        return this.inventoryId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public Long getFilmId() {
        return this.filmId;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public String getFilmTitle() {
        return this.filmTitle;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getStoreId() {
        return this.storeId;
    }
}
