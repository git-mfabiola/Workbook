package ires.corso.test;

import java.time.LocalDate;

public class Libro {
    private String titolo;
    private String autore;
    private String sinossi;
    private LocalDate datapub;
    private Genere genere;

    public enum Genere {
        Fantascienza,
        Avventura,
        Biografia,
        Drammatico
    }

    private enum Giudiziopers {
        livello1,
        livello2,
        livello3,
        livello4,
        livello5
    }

    public Libro(String titolo, String autore, String sinossi, LocalDate datapub, Genere genere) {
        this.titolo = titolo;
        this.autore = autore;
        this.sinossi = sinossi;
        this.datapub = datapub;
        this.genere = genere;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getSinossi() {
        return sinossi;
    }

    public void setSinossi(String sinossi) {
        this.sinossi = sinossi;
    }

    public LocalDate getDatapub() {
        return datapub;
    }

    public void setDatapub(LocalDate datapub) {
        this.datapub = datapub;
    }
}
