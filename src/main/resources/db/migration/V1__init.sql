CREATE TABLE adresa
(
    id    INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    ulice VARCHAR(255) NOT NULL,
    obec  VARCHAR(255) NOT NULL,
    psc   CHAR(5)      NOT NULL
);

CREATE TABLE osoba
(
    id             INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, // primární klíč
    jmeno          VARCHAR(100) NOT NULL,
    prijmeni       VARCHAR(100) NOT NULL,
    datum_narozeni DATE         NOT NULL,
    adresa_id      BIGINT       NOT NULL,
    FOREIGN KEY (adresa_id) REFERENCES adresa (id)
);

CREATE INDEX ON adresa (obec); // index pro řazení dle obce
CREATE INDEX ON osoba (prijmeni, jmeno); // index pro řazení dle příjmení, jméno
CREATE INDEX ON osoba (datum_narozeni, prijmeni); // index pro řazení dle datum narození, příjmení