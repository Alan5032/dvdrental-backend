package dvdrental.typedefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Long filmId;
    @Column(name = "title")
    private String filmTitle;

    public Film() {
    }

    public Film(Long filmId, String filmTitle) {
        this.filmId = filmId;
        this.filmTitle = filmTitle;
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
}
