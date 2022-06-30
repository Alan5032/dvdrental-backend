package dvdrental.typedefs;

import javax.persistence.*;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "film_gen")
    @SequenceGenerator(name = "film_gen", sequenceName = "film_film_id_seq", allocationSize = 1)
    @Column(name = "film_id")
    private Long filmId;
    @Column(name = "title")
    private String filmTitle;

    public Film() {
    }

    public Film(String filmTitle) {
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
