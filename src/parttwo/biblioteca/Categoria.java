package parttwo.biblioteca;

public class Categoria {
    private String titolo;
    private String descrizione;

    public String getTitolo() {
        return titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public Categoria(String titolo, String descrizione) {
        this.titolo = titolo;
        this.descrizione = descrizione;
    }
}
