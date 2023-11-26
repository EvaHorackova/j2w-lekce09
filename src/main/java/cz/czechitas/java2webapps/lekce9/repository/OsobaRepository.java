package cz.czechitas.java2webapps.lekce9.repository;

import cz.czechitas.java2webapps.lekce9.entity.Osoba;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

/**
 * Repository pro tabulku {@code osoba}.
 */
@Repository
public interface OsobaRepository extends JpaRepository<Osoba, Long> { //JPA dědí z Crud, JPA podporuje objekty typu pageable
  /**
   * Vyhledá všechny osoby s adresou v dané obci.
   *
   * Varianta pomocí HQL.
   */
  @Query("SELECT o FROM Osoba o JOIN o.adresa a WHERE a.obec = ?1")
  Page<Osoba> findByObec(String obec, Pageable pageable); // nevrací typ List, ale typ Page

  /**
   * Vyhledá všechny osoby s adresou v dané obci.
   *
   * Varianta pomocí Spring Data JPA.
   */
  Page<Osoba> findOsobaByAdresa_Obec(String obec, Pageable pageable); // hledání ve druhé tabulce Adresa (podle sloupce obec v adrese)

  /**
   * Vyhledá všechny osoby, které se narodily v daný den nebo dříve.
   */
  Page<Osoba> findByDatumNarozeniBefore(LocalDate datum, Pageable pageable); // hledej podle sloupce datum narození, když tam není nic dalšího- hledám na přesnou shodu, můžu přidat Before/After/StartingWith (začíná), IgnoreCase (ignoruje velikost písmen), může tam být negace

  /**
   * Vyhledá všechny osoby, jejichž příjmení začíná na uvedený text.
   */
  Page<Osoba> findByPrijmeniStartingWithIgnoreCaseOrderByPrijmeniDesc(String prijmeni, Pageable pageable); // CTRL + mezerník

  public Page<Osoba> seznamDlePrijmeni(String prijmeni, Pageable pageable);

  /**
   * Vyhledá všechny osoby, které se narodily v rozmezí zadaných let.
   */
  @Query("SELECT o FROM Osoba o WHERE YEAR(o.datumNarozeni) BETWEEN :pocatecniRok AND :koncovyRok") // query z SQL
  Page<Osoba> findByRok(@Param("pocatecniRok") int pocatecniRok, @Param("koncovyRok") int koncovyRok, Pageable pageable); // findByRok si nadefinuji pomocí skládání podmínek za sebe - počáteční rok a koncový rok jsou parametry

}