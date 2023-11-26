package cz.czechitas.java2webapps.lekce9.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

/**
 * Entita pro uložení údajů o osobě.
 */
@Entity
public class Osoba {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // primární klíč
  private Long id;

  private String jmeno;

  private String prijmeni;

  private LocalDate datumNarozeni;

  @ManyToOne(fetch = FetchType.LAZY, optional = false) // napojení na entitu adresa
  private Adresa adresa;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getJmeno() {
    return jmeno;
  }

  public void setJmeno(String jmeno) {
    this.jmeno = jmeno;
  }

  public String getPrijmeni() {
    return prijmeni;
  }

  public void setPrijmeni(String prijmeni) {
    this.prijmeni = prijmeni;
  }

  public LocalDate getDatumNarozeni() {
    return datumNarozeni;
  }

  public void setDatumNarozeni(LocalDate datumNarozeni) {
    this.datumNarozeni = datumNarozeni;
  }

  public Adresa getAdresa() {
    return adresa;
  }

  public void setAdresa(Adresa adresa) {
    this.adresa = adresa;
  }
}