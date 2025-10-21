package rvabackend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "banka")
public class Banka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String naziv;

    @Column(length = 100)
    private String kontakt;

    @Column
    private Integer pib;

    public Banka() {}

    public Banka(Integer id, String naziv, String kontakt, Integer pib) {
        this.id = id;
        this.naziv = naziv;
        this.kontakt = kontakt;
        this.pib = pib;
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

    public String getKontakt() {
        return kontakt;
    }
    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public Integer getPib() {
        return pib;
    }
    public void setPib(Integer pib) {
        this.pib = pib;
    }
}
