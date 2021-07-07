package ires.corso.test;

import parttwo.todo.ToDoRepository;

import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Serializzazione {

    private static boolean _init = false;
    private static String _fileName;
    private static ToDoRepository _repository = null;

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

    public static ToDoRepository deserializeFile() throws IOException {
        try {

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
}
