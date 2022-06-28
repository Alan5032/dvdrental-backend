package dvdrental.services;

import dvdrental.repositories.FilmRepository;
import dvdrental.typedefs.Film;
import dvdrental.typedefs.Inventory;
import dvdrental.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class InventoryService extends DVDService<Inventory, InventoryRepository> {

    private final FilmRepository filmRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository, FilmRepository filmRepository) {
        super(inventoryRepository);
        this.filmRepository = filmRepository;
    }

    @Override
    public List<Inventory> getAll() {
        List<Inventory> inventories = repo.findAll();
        for (Inventory inventory : inventories) {
            Film film = filmRepository.findById(inventory.getFilmId()).orElseThrow(
                    () -> new IllegalArgumentException("No film with inventory's film ID.")
            );
            String filmTitle = film.getFilmTitle();
            inventory.setFilmTitle(filmTitle);
        }
        return inventories;

    }

    @Override
    public Inventory get(Long inventoryId) {
        Inventory inventory = repo.findById(inventoryId).orElseThrow(
                () -> new IllegalArgumentException("No inventory with such id.")
        );
        Film film = filmRepository.findById(inventory.getFilmId()).orElseThrow(
                () -> new IllegalArgumentException("No film with inventory's film ID.")
        );
        String filmTitle = film.getFilmTitle();
        inventory.setFilmTitle(filmTitle);
        return inventory;
    }

    @Transactional
    public void update(Long inventoryId, Long filmId, String filmTitle, Long storeId) {
        Inventory inventory = repo.findById(inventoryId).orElseThrow(
                () -> new IllegalArgumentException("No inventory with such id.")
        );
        if (filmId != null) {
            inventory.setFilmId(filmId);
        }
        if (filmTitle != null && filmTitle.length() > 0) {
            inventory.setFilmTitle(filmTitle);
        }
        if (storeId != null) {
            inventory.setStoreId(storeId);
        }
    }
}
