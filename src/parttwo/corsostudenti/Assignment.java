package parttwo.corsostudenti;

public class Assignment {
    //    - Assignment (titolo, descrizione)
    private String titolo;
    private String descrizione;

    public String getTitolo() { return titolo; }

    public String getDescrizione() { return descrizione; }

    public Assignment(String titolo, String descrizione) {
        this.titolo = titolo;
        this.descrizione = descrizione;
    }
}
