package parttwo.todo;

import java.time.LocalDate;
import java.util.Scanner;

public class ToDoApplication {

    public static void main(String[] args) {
        ToDoRepository.getToDoRepository().add(new ToDo(1L,"Title 1", "Desc 1",LocalDate.now(), LocalDate.of(2021, 12, 1), ToDo.Priorità.BASSA, ToDo.Stato.IN_ESECUZIONE));
        ToDoRepository.getToDoRepository().add(new ToDo(2L,"Title 2", "Desc 2",LocalDate.now(), LocalDate.of(2021, 9, 1), ToDo.Priorità.MEDIA, ToDo.Stato.ANNULLATA));
        ToDoRepository.getToDoRepository().add(new ToDo(3L,"Title 3", "Desc 3",LocalDate.now(), LocalDate.of(2021, 11, 1), ToDo.Priorità.ALTA, ToDo.Stato.COMPLETATA));
        ToDoRepository.getToDoRepository().add(new ToDo(4L,"Title 4", "Desc 4",LocalDate.now(), LocalDate.of(2021, 8, 1), ToDo.Priorità.BASSA, ToDo.Stato.IN_ESECUZIONE));
        ToDoRepository.getToDoRepository().add(new ToDo(5L,"Title 5", "Desc 5",LocalDate.now(), LocalDate.of(2021, 10, 1), ToDo.Priorità.ALTA, ToDo.Stato.COMPLETATA));

        menu();
    }

    // GRUPPO 3/4:

    // 1. Deserializza il repository da file (carica i dati dell'ultimo salvataggio)
    //    creando una classe Repository

    // 2. Gestione del MENU principale con un loop e due switch

    // 3. In corrispondenza di una scelta dell'utente (ramo dello switch) chiama
    //    le classi necessarie per svolgere l'azione

    // 4. Chiede conferma e serializza in uscita

    // 5. Fornisce anche i metodi della classe "lettore" di quiz... askForInput , display
    // Deserialization
    public static void menu() {
        boolean continua = true;

        while (continua) {
            System.out.println("TO DO LIST");
            System.out.println("");
            System.out.println("1. visualizza lista ");
            System.out.println("2. aggiungi, modifica, rimuovi ");
            System.out.println("3. import, export ");
            System.out.println("4. uscita ");

            int input = askInput();

            switch (input) {
                case 1:
                    System.out.println("1. per priorità");
                    System.out.println("2. per stato");
                    System.out.println("3. per data");
                    input = askInput();
                    switch (input) {
                        case 1:
                            ToDoList.viewByPriority();
                            break;
                        case 2:
                            ToDoList.viewByState();
                            break;
                        case 3:
                            ToDoList.viewByDate();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1. aggiungi");
                    System.out.println("2. modifica");
                    System.out.println("3. rimuovi");
                    input = askInput();
                    switch (input) {
                        case 1:
                            ToDoManager.createNewToDo();
                            break;
                        case 2:
                            ToDoManager.updateToDo();
                            break;
                        case 3:
                            ToDoManager.removeToDo();
                            break;
                    }
                    break;
                case 3:
                    System.out.println("1. import");
                    System.out.println("2. export");

                    break;
                case 4:
                    System.out.println("sei uscito dal programma");
                    continua = false;
                    break;
            }
        }
    }

    public static int askInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}