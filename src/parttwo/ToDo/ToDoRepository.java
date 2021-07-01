package parttwo.ToDo;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ToDoRepository implements Serializable {
    /* GESTORE DELL'ARCHIVIO DEI TO-DO == DATABASE */

    // Contiene una HashMap di tutti i TO-DO a sistema:
    // - implementa il metodo di salvataggio su file
    // - implementa il metodo di caricamento da file
    // - metodi per individuare, aggiungere, eliminare un TO-DO
    // - restituisce una copia di tutti i TO-DO come ArrayList, da
    //   usare per le visualizzazioni di ToDoList
    // Serializzabile con la funzione writeObject()

    //Mappa _data
    Map<Long, ToDo> _data = new HashMap<>();

    private static ToDoRepository _repository = null;

    //SERIALIZZIAZIONE

    public void serializefile() throws IOException {

        String filename = "todolistfile";

        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream("todolistfile.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(_repository);

            out.close();
            file.close();

            System.out.println("Object has been serialized");
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    }
    //DESERIALIZZAZIONE

    public static ToDoRepository deserializeFile() throws IOException {
        try {

            // Reading the object from a file
            FileInputStream file = new FileInputStream("todolistfile.txt");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            _repository = (ToDoRepository) in.readObject();

            in.close();
            file.close();

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("IOException is caught");
        }
        return _repository;
    }

    public static ToDoRepository getToDoRepository() {
        return _repository;
    }

    // aggiungere
    public void add(ToDo t) {
        _data.put(t.getId(), t);
    }

    //modificare
    public void update(ToDo t) {
        // si prende l'ID dall'oggetto t
        // si recupera dalla mappa il TO-DO corrispondente con get(t), per controllo
        // si sostituisce con put(ID, t)
        _data.get(t.getId());

        // controllo
        Set<Long> sl = _data.keySet();
        Iterator<Long> longIter = sl.iterator();

        while (longIter.hasNext()) {
            if (longIter.next() == t.getId()) {
                _data.put(t.getId(), t);
            } else {
                System.out.println("il todo non c'è ");
            }

            _data.put(t.getId(), t);
        }
    }
        //eliminare
        public void delete (Long ID){
            _data.remove(ID);
        }

        public List<ToDo> getToDoList () {
            // restituisce lista di tutti i TO-DO esistenti
            ArrayList<ToDo> todolist = new ArrayList<>(_data.values());
            return todolist;
        }
    }
