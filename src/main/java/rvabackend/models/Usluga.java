package rvabackend.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "usluga")
public class Usluga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String naziv;

    @Column(name = "opis_usluge", length = 255)
    private String opisUsluge;

    @Column(name = "datum_ugovora")
    private LocalDate datumUgovora;

    @Column(precision = 10, scale = 2)
    private BigDecimal provizija;

    @ManyToOne
    @JoinColumn(name = "filijala")
    private Filijala filijala;

    @ManyToOne
    @JoinColumn(name = "korisnik")
    private KorisnikUsluge korisnik;

    public Usluga() {}

    public Usluga(String naziv, String opisUsluge, LocalDate datumUgovora,
                  BigDecimal provizija, Filijala filijala, KorisnikUsluge korisnik) {
        this.naziv = naziv;
        this.opisUsluge = opisUsluge;
        this.datumUgovora = datumUgovora;
        this.provizija = provizija;
        this.filijala = filijala;
        this.korisnik = korisnik;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpisUsluge() {
        return opisUsluge;
    }
    public void setOpisUsluge(String opisUsluge) {
        this.opisUsluge = opisUsluge;
    }

    public LocalDate getDatumUgovora() {
        return datumUgovora;
    }
    public void setDatumUgovora(LocalDate datumUgovora) {
        this.datumUgovora = datumUgovora;
    }

    public BigDecimal getProvizija() {
        return provizija;
    }
    public void setProvizija(BigDecimal provizija) {
        this.provizija = provizija;
    }

    public Filijala getFilijala() {
        return filijala;
    }
    public void setFilijala(Filijala filijala) {
        this.filijala = filijala;
    }

    public KorisnikUsluge getKorisnik() {
        return korisnik;
    }
    public void setKorisnik(KorisnikUsluge korisnik) {
        this.korisnik = korisnik;
    }
}