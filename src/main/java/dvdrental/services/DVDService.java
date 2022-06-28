package dvdrental.services;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public class DVDService<T, Repository extends JpaRepository<T, Long>> {

    protected final Repository repo;

    public DVDService(Repository repo) {
        this.repo = repo;
    }

    public List<T> getAll() {
        return repo.findAll();
    }

    public T get(Long id) {
        return repo.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No entity with such id.")
        );
    }

    @Transactional
    public void add(T object) {
        repo.save(object);
    }

    @Transactional
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("No entity with such id.");
        }
        repo.deleteById(id);
    }
}
