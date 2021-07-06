package parttwo.todo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ToDoRepository implements Serializable {


    private static boolean _init = false;               // flag che indica se il ToDoRepository è stato inizializzato
    private static String _fileName;                    // file da usare per serializzazione/deserializzazione
    private static ToDoRepository _repository = null;   // unica istanza del repository;

    public static boolean init(String fileName) {
        try {
            Path p = Paths.get(fileName);
            _fileName = p.toString();
            _init = true;
        } catch (InvalidPathException ipe) {
            System.out.println(ipe.getMessage());
        }
        return _init;
    }

    public static ToDoRepository getToDoRepository() throws Exception {
        if (!_init) {
            throw new Exception("ToDo Repository has not been initialized");
        }
        if (_repository == null) {
            if (!Files.exists(Paths.get(_fileName)))
                _repository = new ToDoRepository();
            else
                deserializeFile();
        }
        return _repository;
    }

    //SERIALIZZIAZIONE
    public void serializefile() throws IOException {

        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(_fileName);
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
            FileInputStream file = new FileInputStream(_fileName);
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

    private Map<Long, ToDo> _data = new HashMap<>();
    private long _idseed;

    private long getNewID() {
        _idseed++;
        return _idseed;
    }

    // aggiungere
    public void add(ToDo t) {
        long newID = getNewID();
        t.setId(newID);
        _data.put(newID, t);
    }

    //modificare
    public void update(ToDo t) {
        // si prende l'ID dall'oggetto t
        // si recupera dalla mappa il TO-DO corrispondente con get(t), per controllo
        // si sostituisce con put(ID, t)
        _data.get(t.getId());

        // controllo
        Set<Long> sl = _data.keySet();
        sl.contains(t.getId());

        if (sl.contains(t.getId())) {
            _data.replace(t.getId(), t);
        } else {
            System.out.println("il todo non c'è ");
        }
    }

    //eliminare
    public void delete(Long ID) {
        _data.remove(ID);
    }

    public List<ToDo> getToDoList() {
        // restituisce lista di tutti i TO-DO esistenti
        ArrayList<ToDo> todolist = new ArrayList<>(_data.values());
        return todolist;
    }
}
