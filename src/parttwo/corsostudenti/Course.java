package parttwo.corsostudenti;

public class Course {
    //    - Course (titolo, descrizione, settore)
    private String titolo;
    private String descrizione;
    private String settore;

    public String getTitolo() { return titolo; }

    public String getDescrizione() { return descrizione; }

    public String getSettore() { return settore; }

    public Course(String titolo, String descrizione, String settore) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.settore = settore;
    }
}
