package parttwo.todo;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

// GRUPPO 3:
public class ToDoImportExport {

    private static String inputfileName = "todolistinput.txt";
    private static String outputfileName = "todolistoutput.txt";

    // converte a stringa

    private static String convertToString(ToDo t) {
        String result = String.format("%s|%s|%s|%s|%s", t.getId().toString(), t.getTitolo(), t.getDescrizione(),
                t.getPriorità().toString(), t.getStato().toString());
        return result;
    }

    private static ToDo convertFromString(String[] args) throws Exception {
        if (args.length != 5) {
            throw new Exception("l'array non è accettabile");
        }
            Long id;
            String title = null;
            String description = null;
            LocalDate dateCreation;
            LocalDate dateExpiration = null;
            ToDo.Priorità priority = null;
            ToDo.Stato state = null;

            //controlli sui valori delle properties
            if (args[1] != null)
                title = args[1];
            else
                System.out.println("Il titolo era nullo.");

            if (args[2] != null)
                description = args[2];
            else
                System.out.println("La descrizione era nulla.");

            if (args[4] != null)
                dateExpiration = LocalDate.parse(args[4]);
            else
                System.out.println("La data è nulla.");

            if (args[5].equals("ALTA")) {
                priority = ToDo.Priorità.ALTA;
            } else if (args[5].equals("MEDIA")) {
                priority = ToDo.Priorità.MEDIA;
            } else if (args[5].equals("BASSA")) {
                priority = ToDo.Priorità.BASSA;
            } else
                System.out.println("Valore di priorità non valido.");

            if (args[6].equals("DA_FARE")) {
                state = ToDo.Stato.DA_FARE;
            } else if (args[6].equals("IN_ESECUZIONE")) {
                state = ToDo.Stato.IN_ESECUZIONE;
            } else if (args[6].equals("COMPLETATA")) {
                state = ToDo.Stato.COMPLETATA;
            } else if (args[6].equals("ANNULLATA")) {
                state = ToDo.Stato.ANNULLATA;
            } else
                System.out.println("Valore non valido.");

            ToDo td = new ToDo(title, description, dateExpiration, priority, state);
            return td;
        }

    // esporta su file
        public static void exportToFile () throws Exception {
            // Chiede all'utente un nome file di export...

            try (PrintWriter outputStream = new PrintWriter(new FileWriter(outputfileName))) {
                List<ToDo> toDoList = ToDoRepository.getToDoRepository().getToDoList();
                Iterator<ToDo> tdi = toDoList.iterator();

                while (tdi.hasNext()) {
                    String sToDo = convertToString(tdi.next());
                    outputStream.println(sToDo);
                }
            }
        }
    // importa da file
        public static void importToFile () throws Exception {
            // Chiede all'utente un nome file di import...

            ArrayList<String> fileLines = new ArrayList<>();

            try (BufferedReader inputStream = new BufferedReader(new FileReader(inputfileName))) {
                String l;
                while ((l = inputStream.readLine()) != null) {
                    fileLines.add(l);
                }
            }
            // iteratore per splittare l'array
            Iterator<String> itrLines = fileLines.iterator();
            int numImportedToDo = 0;
            while (itrLines.hasNext()) {
                String line = itrLines.next();
                String[] splitter = line.split("\\|");

                ToDo td = convertFromString(splitter);
                ToDoRepository.getToDoRepository().add(td);
                numImportedToDo++;
            }
        }
    }
