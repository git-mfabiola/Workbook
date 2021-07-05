package parttwo.todo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// GRUPPO 2:
public class ToDoManager {
    //CHIEDE AL UTENTE COSA VUOLE FARE AGGIUNGERE ECC

    // Classe responsabile per le operazioni sull'insieme dei TO-DO:
    // - ADD   metodi per creazione nuovo TO-DO
    // - UPDATE   REMOVE metodi per la modifica, la rimozione
    // - gestisce input utente (cioè loop di richiesta di quali campi devono essere modificati)
    // - ha al suo interno funzioni di controllo sull'input utente
    private static Scanner scanner = new Scanner(System.in);

    public static void createNewToDo() {
        // chiedo al utente di inserire il to do

        String titolo = inserisciTitolo();
        String descrizione = inserisciDescrizione();
        LocalDate deliveryDate = inserisciDataScadenza();
        ToDo.Priorità priorità = scegliPriorità();
        ToDo.Stato stato = scegliStato();

        ToDo td = new ToDo(titolo, descrizione, deliveryDate, priorità, stato);

        ToDoRepository.getToDoRepository().add(td);
    }

    public static void removeToDo() {
        System.out.println("Inserisci l'id da eliminare ");
        Long id = scanner.nextLong();

        System.out.println("Confermi l'eliminazione");
        System.out.println("1 Si");
        System.out.println("2 No");
        int scelta  = scanner.nextInt();

        switch (scelta) {
            case 1:
                ToDoRepository.getToDoRepository().delete(id);
                System.out.println("Eliminazione effettuata");
                break;
            case 2:
                System.out.println("Eliminazione annullata");
                break;
            default:
                System.out.println("Scelta errata, eliminazione annullata");
                break;
        }
    }

    public static void updateToDo() {
        // Chiede quale Id si vuole modificare
        // Si chiede un "clone" del TO-DO
        // Loop di richiesta dati da modificare
        // Salvataggio delle modifiche tramite ToDoRepository (update...)

        System.out.println("Inserisci l'id del todo da modificare ");
        Long id = scanner.nextLong();

        List<ToDo> toDoList = ToDoRepository.getToDoRepository().getToDoList();

        List<ToDo> listaToDoFiltrataPerId = toDoList
                .stream()
                .filter(todo -> todo.getId().equals(id))
                .collect(Collectors.toList());

        ToDo todoTrovato = listaToDoFiltrataPerId.get(0);

        String titolo = inserisciTitolo();
        if (!titolo.isEmpty()) {
            todoTrovato.setTitolo(titolo);
        }

        String descrizione = inserisciDescrizione();
        if (!descrizione.isEmpty()) {
            todoTrovato.setDescrizione(descrizione);
        }

        System.out.println("Vuoi modificare la data di scadenza? " + todoTrovato.getDatascadenza());
        System.out.println("1 Si");
        System.out.println("2 No");

        int scelta = scanner.nextInt();

        switch (scelta) {
            case 1:
                LocalDate deliveryDate = inserisciDataScadenza();
                todoTrovato.setDatascadenza(deliveryDate);
                break;
            case 2:
                break;
            default:
                System.out.println("Scelta errata, non verrà effettuata alcuna modifica");
                break;
        }

        ToDo.Priorità priorità = scegliPriorità();
        if (!priorità.equals(todoTrovato.getPriorità())) {
            todoTrovato.setPriorità(priorità);
        }

        ToDo.Stato stato = scegliStato();
        if (!stato.equals(todoTrovato.getStato())) {
            todoTrovato.setStato(stato);
        }

        System.out.println("Confermi la modifica");
        System.out.println("1 Si");
        System.out.println("2 No");
        int sceltaFinale = scanner.nextInt();

        switch (sceltaFinale) {
            case 1:
                ToDoRepository.getToDoRepository().update(todoTrovato);
                System.out.println("Modifica effettuata");
                break;
            case 2 :
                System.out.println("Modifica annullata");
                break;
            default:
                System.out.println("Scelta errata, modifica annullata");
                break;
        }
    }

    private static String inserisciTitolo() {
        System.out.println("inserisci il titolo ");
        String titolo = scanner.nextLine();
        return titolo;
    }

    private static String inserisciDescrizione() {
        System.out.println("inserisci il descrizione ");
        String descrizione = scanner.nextLine();
        return descrizione;
    }

    private static LocalDate inserisciDataScadenza() {
        System.out.println("inserisci il data scadenza yyyy/mm/dd ");
        String datascadenza = scanner.next();

        DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate deliveryDate = LocalDate.parse(datascadenza, form);
        return deliveryDate;
    }

    private static ToDo.Priorità scegliPriorità() {
        System.out.println("Scegli la priorità ");
        System.out.println("1 ALTA");
        System.out.println("2 MEDIA");
        System.out.println("3 BASSA");
        int sceltaPriorità = scanner.nextInt();

        ToDo.Priorità priorità;
        switch (sceltaPriorità) {
            case 1:
                priorità = ToDo.Priorità.ALTA;
                break;
            case 2:
                priorità = ToDo.Priorità.MEDIA;
                break;
            case 3:
                priorità = ToDo.Priorità.BASSA;
                break;
            default:
                priorità = ToDo.Priorità.BASSA;
                break;
        }

        return priorità;
    }

    private static ToDo.Stato scegliStato() {
        System.out.println("Scegli lo stato ");
        System.out.println("1 DA_FARE");
        System.out.println("2 IN_ESECUZIONE");
        System.out.println("3 COMPLETATA");
        System.out.println("4 ANNULLATA");
        int sceltaStato = scanner.nextInt();

        ToDo.Stato stato;
        switch (sceltaStato) {
            case 1:
                stato = ToDo.Stato.DA_FARE;
                break;
            case 2:
                stato = ToDo.Stato.IN_ESECUZIONE;
                break;
            case 3:
                stato = ToDo.Stato.COMPLETATA;
                break;
            case 4:
                stato = ToDo.Stato.ANNULLATA;
                break;
            default:
                stato = ToDo.Stato.DA_FARE;
                break;
        }
        return stato;
    }
}
