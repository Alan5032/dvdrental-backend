package dvdrental.typedefs;

import javax.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_gen")
    @SequenceGenerator(name = "inventory_gen", sequenceName = "inventory_inventory_id_seq", allocationSize = 1)
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

    public Inventory(Long filmId, Long storeId) {
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
