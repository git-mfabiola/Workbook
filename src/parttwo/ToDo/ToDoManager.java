package parttwo.ToDo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// GRUPPO 2:
public class ToDoManager
{
    //CHIEDE AL UTENTE COSA VUOLE FARE AGGIUNGERE ECC

    // Classe responsabile per le operazioni sull'insieme dei TO-DO:
    // - ADD   metodi per creazione nuovo TO-DO
    // - UPDATE   REMOVE metodi per la modifica, la rimozione
    // - gestisce input utente (cioè loop di richiesta di quali campi devono essere modificati)
    // - ha al suo interno funzioni di controllo sull'input utente
    Scanner scanner1 = new Scanner(System.in);

    public void createNewToDo() {
        // dichiarazione
        ToDo td;

        // chiedo al utente di inserire il to do

        System.out.println("inserisci il titolo ");
        String titolo = scanner1.nextLine();
        System.out.println("inserisci il descrizione ");
        String descrizione = scanner1.nextLine();

        LocalDate datainserimento = LocalDate.now();

        System.out.println("inserisci il data scadenza yyyy/mm/dd ");
        String datascadenza = scanner1.nextLine();

        DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy/mm/dd");
        LocalDate deliveryDate = LocalDate.parse(datascadenza, form);
        LocalDate data = LocalDate.parse(datascadenza);

        td = new ToDo(titolo, descrizione, datainserimento, deliveryDate);
    }
    public void updateToDo() {
        // Chiede quale Id si vuole modificare
        // Si chiede un "clone" del TO-DO
        // Loop di richiesta dati da modificare
        // Salvataggio delle modifiche tramite ToDoRepository (update...)

    }
}
