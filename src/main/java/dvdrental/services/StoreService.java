package dvdrental.services;

import dvdrental.typedefs.Store;
import dvdrental.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StoreService extends DVDService<Store, StoreRepository> {

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        super(storeRepository);
    }

    @Transactional
    public void updateLocation(Long storeId, Long managerId, Long addressId) {
        Store store = repo.findById(storeId).orElseThrow(
                () -> new IllegalArgumentException("No store with such id.")
        );
        if (managerId != null) {
            store.setManagerId(managerId);
        }
        if (addressId != null) {
            store.setAddressId(addressId);
        }
    }
}
