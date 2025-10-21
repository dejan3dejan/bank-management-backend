package rvabackend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "korisnik_usluge")
public class KorisnikUsluge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String ime;

    @Column(length = 100)
    private String prezime;

    @Column(name = "maticni_broj", length = 100)
    private String maticniBroj;

    public KorisnikUsluge() {}

    public KorisnikUsluge(String ime, String prezime, String maticniBroj) {
        this.ime = ime;
        this.prezime = prezime;
        this.maticniBroj = maticniBroj;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }
    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }
    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }
}