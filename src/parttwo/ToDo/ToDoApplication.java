package parttwo.ToDo;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class ToDoApplication {

    // GRUPPO 3/4:

    // 1. Deserializza il repository da file (carica i dati dell'ultimo salvataggio)
    //    creando una classe Repository

    // 2. Gestione del MENU principale con un loop e due switch

    // 3. In corrispondenza di una scelta dell'utente (ramo dello switch) chiama
    //    le classi necessarie per svolgere l'azione

    // 4. Chiede conferma e serializza in uscita

    // 5. Fornisce anche i metodi della classe "lettore" di quiz... askForInput , display
    // Deserialization
    public void menu() {
        System.out.println("TO DO LIST");
        System.out.println("");
        System.out.println("1. visualizza lista ");
        System.out.println("2. aggiungi, modifica, rimuovi ");
        System.out.println("3. import, export ");
        System.out.println("4. uscita ");

        String input = askInput();

        while (true) {
            switch (input) {
                case "1":
                    System.out.println("1. per priorità");
                    System.out.println("2. per stato");
                    System.out.println("3. per data");
                    input = askInput();
                    switch (input) {
                        case "1"://invoco metodo
                            break;
                        case "2"://invoco metodo
                            break;
                        case "3"://invoco metodo
                            break;
                    }
                    break;
                case "2":
                    System.out.println("1. aggiungi");
                    System.out.println("2. modifica");
                    System.out.println("3. rimuovi");
                    switch (input) {


                        case "2":// invoco metodo
                            break;
                    }
                case "3":
                    System.out.println("1. import");
                    System.out.println("2. export");

                    break;
                case "4":
                    System.out.println("sei uscito dal programma");
                    System.exit(0);
                    break;
            }
        }
    }
    public static String askInput()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}