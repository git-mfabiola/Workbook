package parttwo.ToDo;

import java.io.Serializable;
import java.time.LocalDate;

public class ToDo implements Serializable
{
    // classe principale
    // ...costruttore con ID incrementale...

    private static Long id;
    protected Long idSeed;
    private String titolo;
    private String descrizione;
    protected LocalDate datadiinserimento;
    private LocalDate datascadenza;
    private enum priorità{
        ALTA,
        MEDIA,
        BASSA,
    }
    private enum stato{
        DA_FARE,
        IN_ESECUZIONE,
        COMPLETATA,
        ANNULLATA
    }
    //costruttore
    public ToDo(String titolo, String descrizione, LocalDate datadiinserimento, LocalDate datascadenza) {
        this.id = getNewId();
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.datadiinserimento = datadiinserimento;
        this.datascadenza = datascadenza;
    }
    //costruttore
    public ToDo(Long id, String titolo, String descrizione, LocalDate datadiinserimento, LocalDate datascadenza) {
        this.id = id;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.datadiinserimento = datadiinserimento;
        this.datascadenza = datascadenza;
    }

    public void setTitolo(String titolo) { this.titolo = titolo; }

    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

    public void setDatascadenza(LocalDate datascadenza) { this.datascadenza = datascadenza; }

    public Long getId() { return id; }


    protected long getNewId() {
        return ++idSeed;
    }


    public String getTitolo() { return titolo; }

    public String getDescrizione() { return descrizione; }

    public LocalDate getDatadiinserimento() { return datadiinserimento; }

    public LocalDate getDatascadenza() { return datascadenza; }

    public ToDo cloneForUpdate() {
        // fabbrica una copia esatta del To-Do (compreso l'ID)
        ToDo nuovoTodo = new ToDo(this.id,this.titolo,this.descrizione,this.datadiinserimento,this.datascadenza);
        return nuovoTodo;
    }
}
