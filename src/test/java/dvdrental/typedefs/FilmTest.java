package dvdrental.typedefs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilmTest {

    private final String filmTitle = "amazing name";

    private Film film1;
    private Film film2;

    @BeforeEach
    void beforeEach() {
        film1 = new Film();
        film2 = new Film(filmTitle);
    }

    @Test
    void constructedGetFilmTitle() {
        assertEquals(filmTitle, film2.getFilmTitle());
    }

    @Test
    void setFilmId() {
        Long filmId = 99999L;
        film1.setFilmId(filmId);
        assertEquals(filmId, film1.getFilmId());
    }

    @Test
    void setFilmTitle() {
        film1.setFilmTitle(filmTitle);
        assertEquals(filmTitle, film2.getFilmTitle());
    }
}
