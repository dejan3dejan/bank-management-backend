package rvabackend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "filijala")
public class Filijala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String adresa;

    @Column(name = "broj_pultova")
    private Integer brojPultova;

    @Column(name = "poseduje_sef")
    private Boolean posedujeSef;

    @ManyToOne
    @JoinColumn(name = "banka", nullable = false)
    private Banka banka;

    public Filijala(){

    }

    public Filijala(String adresa, Integer brojPultova, Boolean posedujeSef, Banka banka) {
        this.adresa = adresa;
        this.brojPultova = brojPultova;
        this.posedujeSef = posedujeSef;
        this.banka = banka;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdresa() {
        return adresa;
    }
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Integer getBrojPultova() {
        return brojPultova;
    }
    public void setBrojPultova(Integer brojPultova) {
        this.brojPultova = brojPultova;
    }

    public Boolean getPosedujeSef() {
        return posedujeSef;
    }
    public void setPosedujeSef(Boolean posedujeSef) {
        this.posedujeSef = posedujeSef;
    }

    public Banka getBanka() {
        return banka;
    }
    public void setBanka(Banka banka) {
        this.banka = banka;
    }
}
