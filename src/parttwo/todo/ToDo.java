package parttwo.todo;

import java.io.Serializable;
import java.time.LocalDate;

public class ToDo implements Serializable
{

    private Long id;
    private String titolo;
    private String descrizione;
    private LocalDate datadiinserimento;
    private LocalDate datascadenza;
    private Priorità priorità;
    private Stato stato;

    //costruttore
    public ToDo(String titolo, String descrizione, LocalDate datascadenza, Priorità priorità, Stato stato) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.datadiinserimento = LocalDate.now();
        this.datascadenza = datascadenza;
        this.priorità = priorità;
        this.stato = stato;
    }

//    public ToDo(Long id, String titolo, String descrizione, LocalDate datadiinserimento, LocalDate datascadenza, Priorità priorità, Stato stato) {
//        this.id = id;
//        this.titolo = titolo;
//        this.descrizione = descrizione;
//        this.datadiinserimento = datadiinserimento;
//        this.datascadenza = datascadenza;
//        this.priorità = priorità;
//        this.stato = stato;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public LocalDate getDatadiinserimento() {
        return datadiinserimento;
    }

    public void setDatadiinserimento(LocalDate datadiinserimento) {
        this.datadiinserimento = datadiinserimento;
    }

    public LocalDate getDatascadenza() {
        return datascadenza;
    }

    public void setDatascadenza(LocalDate datascadenza) {
        this.datascadenza = datascadenza;
    }

    public Priorità getPriorità() {
        return priorità;
    }

    public void setPriorità(Priorità priorità) {
        this.priorità = priorità;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public ToDo cloneForUpdate() {
        // fabbrica una copia esatta del To-Do (compreso l'ID)
        ToDo nuovoTodo = new ToDo(this.titolo,this.descrizione,this.datascadenza, this.priorità, this.stato);
        nuovoTodo.setId(this.getId());
        nuovoTodo.setDatadiinserimento(this.getDatadiinserimento());
        return nuovoTodo;
    }

    public String prettyPrint(){
        String s = String.format(" ID: %d \n TITOLO: %s \n DESCRIZIONE: %s \n CREATO IL: %s \n CON SCADENZA IL: %s \n CON PRIORITà: %s \n CON STATO: %s",
                getId(), getTitolo(), getDescrizione(), getDatadiinserimento().toString(), getDatascadenza().toString(), getPriorità().toString(),
                getStato().toString());
        return s;
    }

    public enum Stato {
        DA_FARE,
        IN_ESECUZIONE,
        COMPLETATA,
        ANNULLATA
    }

    public enum Priorità {
        ALTA,
        MEDIA,
        BASSA
    }

}
