package ires.corso.test;

import parttwo.todo.ToDo;

import java.util.*;

public class Biblioteca {

    private Map<Long, Libro> _data = new HashMap<>();
    private long _idseed;

    private Biblioteca biblioteca;

    private long getNewID() {
        _idseed++;
        return _idseed;
    }

    // aggiungere
    public void add(Libro l) {
        long newID = getNewID();
        _data.put(newID, l);
    }

    //eliminare
    public void delete(Libro l) {
        long newID = getNewID();
        _data.remove(newID, l);
    }

    public List<Libro> getLibro() {
        // restituisce lista di tutti i libri esistenti
        ArrayList<Libro> libro = new ArrayList<>(_data.values());
        return libro;
    }

    //modifica
    public void update(Libro l) {
        _data.get(getNewID());
        // controllo
        Set<Long> sl = _data.keySet();
        sl.contains(getNewID());

        if (sl.contains(getNewID())) {
            _data.replace(getNewID(), l);
        } else {
            System.out.println("il libro non c'è ");
        }
    }

    //elenco delle istanze
    public void view() throws Exception{
        Biblioteca b = Biblioteca.getBiblioteca();
        List<Libro> libro = b.getLibro();

        Comparator<Libro> comparaPerTitolo = (Libro t1, Libro t2) -> t1.getTitolo().compareTo(t2.getTitolo());
    }
    public List<Libro> getBiblioteca() {
        ArrayList<Libro> listalibri = new ArrayList<>(_data.values());
        return listalibri;
    }
}
