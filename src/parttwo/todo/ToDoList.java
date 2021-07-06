package parttwo.todo;

import java.util.Comparator;
import java.util.List;

// GRUPPO 1:
public class ToDoList {
    // Implementa le funzionalità di visualizzazione con:
    // - ordinamento per priorità
    // - ordinamento per data
    // - ordinamento per stato
    // Si appoggia a un metodo di ToDoRepository per avere una lista (= copia dei TO-DO
    // originali) dei TO-DO attualmente a sistema, cioè un ArrayList facilmente utilizzabile


    public static void viewByPriority() throws Exception {
        // Questa funzione è chiamata qunado l'utente sceglie di visualizzare i dati per priorità...

        ToDoRepository tdr = ToDoRepository.getToDoRepository();
        List<ToDo> todolist = tdr.getToDoList();

        Comparator<ToDo> comparaPerPriorità = (ToDo t1, ToDo t2) -> t1.getPriorità().compareTo(t2.getPriorità());

        todolist.sort(comparaPerPriorità);

        todolist.forEach(todo ->
                System.out.println(todo.getId() +
                        " " +
                        todo.getTitolo() +
                        " " +
                        todo.getDescrizione() +
                        " " +
                        todo.getPriorità()));
    }

    public static void viewByState() throws Exception{
        ToDoRepository tdr = ToDoRepository.getToDoRepository();
        List<ToDo> todolist = tdr.getToDoList();
        Comparator<ToDo> comparaPerStato = (ToDo t1, ToDo t2) -> t1.getStato().compareTo(t2.getStato());

        todolist.sort(comparaPerStato);

        todolist.forEach(todo ->
                System.out.println(todo.getId() +
                        " " +
                        todo.getTitolo() +
                        " " +
                        todo.getDescrizione() +
                        " " +
                        todo.getStato()));
    }

    public static void viewByDate() throws Exception{
        ToDoRepository tdr = ToDoRepository.getToDoRepository();
        List<ToDo> todolist = tdr.getToDoList();

        Comparator<ToDo> comparaPerDataScadenza = (ToDo t1, ToDo t2) -> t1.getDatascadenza().compareTo(t2.getDatascadenza());

        todolist.sort(comparaPerDataScadenza);

        todolist.forEach(todo ->
                System.out.println(todo.getId() +
                        " " +
                        todo.getTitolo() +
                        " " +
                        todo.getDescrizione() +
                        " " +
                        todo.getDatascadenza()));
    }
}