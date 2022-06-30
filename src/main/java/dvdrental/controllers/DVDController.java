package dvdrental.controllers;

import dvdrental.services.*;
import dvdrental.typedefs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.time.OffsetDateTime;

@RestController
public class DVDController {

    private final StaffService staffService;
    private final CustomerService customerService;
    private final StoreService storeService;
    private final RentalService rentalService;
    private final InventoryService inventoryService;

    @Autowired
    public DVDController(StaffService staffService, CustomerService customerService, StoreService storeService,
                         RentalService rentalService, InventoryService inventoryService) {
        this.staffService = staffService;
        this.customerService = customerService;
        this.storeService = storeService;
        this.rentalService = rentalService;
        this.inventoryService = inventoryService;
    }

    @GetMapping()
    public String homePage() {
        return "Welcome to DVD Rental!";
    }

    @GetMapping(value = "/staffs")
    public List<Staff> getStaffs() {
        return staffService.getAll();
    }

    @GetMapping(value = "/staffs/{staffId}")
    public Staff getStaff(@PathVariable("staffId") Long staffId) {
        return staffService.get(staffId);
    }

    @PostMapping(value = "/staffs")
    public ResponseEntity<String> addStaff(@RequestBody Staff staff) {
        staffService.add(staff);
        return new ResponseEntity<>(
                "staffId: " + staff.getStaffId(),
                HttpStatus.OK
        );
    }

    @DeleteMapping(value = "/staffs/{staffId}")
    public void deleteStaff(@PathVariable("staffId") Long staffId) {
        staffService.delete(staffId);
    }

    @PutMapping(value = "/staffs/{staffId}")
    public void updateStaff(@PathVariable("staffId") Long staffId, @RequestParam(required = false) String firstName,
                            @RequestParam(required = false) String lastName,
                            @RequestParam(required = false) Long addressId,
                            @RequestParam(required = false) String email, @RequestParam(required = false) Long storeId,
                            @RequestParam(required = false) String username,
                            @RequestParam(required = false) String password) {
        staffService.update(staffId, firstName, lastName, addressId, email, storeId, username, password);
    }

    @GetMapping(value = "/customers")
    public List<Customer> getCustomers() {
        return customerService.getAll();
    }

    @GetMapping(value = "/customers/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Long customerId) {
        return customerService.get(customerId);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        customerService.add(customer);
        return new ResponseEntity<>(
                "customerId: " + customer.getCustomerId(),
                HttpStatus.OK
        );
    }

    @DeleteMapping(value = "/customers/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long customerId) {
        customerService.delete(customerId);
    }

    @PutMapping(value = "/customers/{customerId}")
    public void updateCustomer(@PathVariable("customerId") Long customerId,
                               @RequestParam(required = false) Long storeId,
                               @RequestParam(required = false) String firstName,
                               @RequestParam(required = false) String lastName,
                               @RequestParam(required = false) String email,
                               @RequestParam(required = false) Long addressId) {
        customerService.update(customerId, storeId, firstName, lastName, email, addressId);
    }

    @GetMapping(value = "/locations")
    public List<Store> getLocations() {
        return storeService.getAll();
    }

    @GetMapping(value = "/locations/{storeId}")
    public Store getLocation(@PathVariable("storeId") Long storeId) {
        return storeService.get(storeId);
    }

    @PostMapping(value = "/locations")
    public ResponseEntity<String> addLocation(@RequestBody Store store) {
        storeService.add(store);
        return new ResponseEntity<>(
                "storeId: " + store.getStoreId(),
                HttpStatus.OK
        );
    }

    @DeleteMapping(value = "/locations/{storeId}")
    public void deleteLocation(@PathVariable("storeId") Long storeId) {
        storeService.delete(storeId);
    }

    @PutMapping(value = "/locations/{storeId}")
    public void updateLocation(@PathVariable("storeId") Long storeId, @RequestParam(required = false) Long managerId,
                               @RequestParam(required = false) Long addressId) {
        storeService.update(storeId, managerId, addressId);
    }

    @GetMapping(value = "/rentals")
    public List<Rental> getRentals() {
        return rentalService.getAll();
    }

    @GetMapping(value = "/rentals/{rentalId}")
    public Rental getRental(@PathVariable("rentalId") Long rentalId) {
        return rentalService.get(rentalId);
    }

    @PostMapping(value = "/rentals")
    public ResponseEntity<String> addRental(@RequestBody Rental rental) {
        rentalService.add(rental);
        return new ResponseEntity<>(
                "rentalId: " + rental.getRentalId(),
                HttpStatus.OK
        );
    }

    @DeleteMapping(value = "/rentals/{rentalId}")
    public void deleteRental(@PathVariable("rentalId") Long rentalId) {
        rentalService.delete(rentalId);
    }

    @PutMapping(value = "/rentals/{rentalId}")
    public void updateLocation(@PathVariable("rentalId") Long rentalId,
                               @RequestParam(required = false) OffsetDateTime rentalDate,
                               @RequestParam(required = false) Long inventoryId,
                               @RequestParam(required = false) Long customerId,
                               @RequestParam(required = false) OffsetDateTime returnDate, @RequestParam(required =
            false) Long staffId) {
        rentalService.update(rentalId, rentalDate, inventoryId, customerId, returnDate, staffId);
    }

    @GetMapping(value = "/inventory")
    public List<Inventory> getInventories() {
        return inventoryService.getAll();
    }

    @GetMapping(value = "/inventory/{inventoryId}")
    public Inventory getInventory(@PathVariable("inventoryId") Long inventoryId) {
        return inventoryService.get(inventoryId);
    }

    @PostMapping(value = "/inventory")
    public ResponseEntity<String> addInventory(@RequestBody Inventory inventory) {
        inventoryService.add(inventory);
        return new ResponseEntity<>(
                "inventoryId: " + inventory.getInventoryId(),
                HttpStatus.OK
        );
    }

    @DeleteMapping(value = "/inventory/{inventoryId}")
    public void deleteInventory(@PathVariable("inventoryId") Long inventoryId) {
        inventoryService.delete(inventoryId);
    }

    @PutMapping(value = "/inventory/{inventoryId}")
    public void updateInventory(@PathVariable("inventoryId") Long inventoryId,
                                @RequestParam(required = false) Long filmId,
                                @RequestParam(required = false) String filmTitle,
                                @RequestParam(required = false) Long storeId) {
        inventoryService.update(inventoryId, filmId, filmTitle, storeId);
    }
}
