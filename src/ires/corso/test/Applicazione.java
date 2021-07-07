package ires.corso.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Applicazione {
    public static void main(String[] args) throws Exception {
        Biblioteca b = Biblioteca.getBiblioteca();
        menu();
    }

    private static void menu() throws Exception {
        boolean continua = true;

        while (continua) {
            System.out.println("BIBLIOTECA");
            System.out.println("");
            System.out.println("1. Visualizza dei volumi esistenti ");
            System.out.println("2. Aggiugi un volume ");
            System.out.println("3. Modifica un volume ");
            System.out.println("4. Eliminazione di un volume ");
            System.out.println("5. Avanzamento lettura ");
            System.out.println("6. Giudizio personale ");
            System.out.println("7. uscita ");

            int input = askInput();

            switch (input) {
                case 1:
                    System.out.println("1. Visualizza dei volumi esistenti ");
                    viewByBook();
                    break;
                case 2:
                    System.out.println("2. Aggiungi un volume ");
                    createNewLibro();
                    break;
                case 3:
                    System.out.println("3. Modifica un volume ");
                    updateLibro();
                    break;
                case 4:
                    System.out.println("4. Eliminazione di un volume ");
                    removeLibro();
                    break;
                case 5:
                    System.out.println("5. Avanzamento lettura ");
                    avanzamentoLett();
                    break;
                case 6:
                    System.out.println("6. Giudizio personale ");
                    giudizioPers();
                    break;
                case 7:
                    System.out.println("Vuoi uscire dal programma? ");
                    System.out.println("1. si");
                    System.out.println("2. no");
                    input = askInput();
                    switch (input) {
                        case 1:
                            System.out.println("sei uscito dal programma");
                            continua = false;
                            break;
                        case 2:
                            break;
                    }
                    break;
            }
        }
    }

    public static int askInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void viewByBook() throws Exception {

        Biblioteca b = Biblioteca.getBiblioteca();
        List<Libro> libro = b.getLibro();

        Comparator<Libro> comparaPerTitolo = (Libro l1, Libro l2) -> l1.getTitolo().compareTo(l2.getTitolo());

        libro.sort(comparaPerTitolo);

        libro.forEach(Libro ->
                System.out.println(
                        Libro.getTitolo() +
                                " " +
                                Libro.getAutore() +
                                " " +
                                Libro.getSinossi() +

                                Libro.getDatapub() +
                                " " +
                                Libro.getGenere()));
    }

    public static void createNewLibro() throws Exception {
        // chiedo al utente di inserire il libro

        String titolo = inserisciTitolo();
        String autore = inserisciAutore();
        String sinossi = inserisciSinossi();
        LocalDate datapubb = inserisciDatapubb();
        Libro.Genere genere = scegliGenere();

        Libro l = new Libro(titolo, autore, sinossi, datapubb, genere);

        Biblioteca.getBiblioteca().add(l);
    }

    public static void updateLibro() throws Exception {

        System.out.println("Inserisci l'id del todo da modificare ");
        Long id = scanner.nextLong();


        System.out.println("Confermi la modifica");
        System.out.println("1 Si");
        System.out.println("2 No");
        int sceltaFinale = scanner.nextInt();

        switch (sceltaFinale) {
            case 1:
                Biblioteca.getBiblioteca().update();
                System.out.println("Modifica effettuata");
                break;
            case 2:
                System.out.println("Modifica annullata");
                break;
            default:
                System.out.println("Scelta errata, modifica annullata");
                break;
        }
    }

    private static Scanner scanner = new Scanner(System.in);

    public static void removeLibro() throws Exception {
        System.out.println("Inserisci l'id da eliminare ");
        Long id = scanner.nextLong();

        System.out.println("Confermi l'eliminazione");
        System.out.println("1 Si");
        System.out.println("2 No");
        int scelta = scanner.nextInt();

        switch (scelta) {
            case 1:
                Biblioteca.getBiblioteca().delete();
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

    public static void avanzamentoLett(){

    }
    public static void giudizioPers(){

    }
    private static String inserisciTitolo() {
        System.out.println("inserisci il titolo ");
        String titolo = scanner.nextLine();
        return titolo;
    }

    private static String inserisciAutore() {
        System.out.println("inserisci il autore ");
        String autore = scanner.nextLine();
        return autore;
    }

    private static String inserisciSinossi() {
        System.out.println("inserisci la sinossi ");
        String sinossi = scanner.nextLine();
        return sinossi;
    }

    private static LocalDate inserisciDatapubb() {
        System.out.println("inserisci la data di pubblicazione yyyy/mm/dd ");
        String datapub = scanner.next();

        DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate pubDate = LocalDate.parse(datapub, form);
        return pubDate;
    }

    private static Libro.Genere scegliGenere() {
        System.out.println("Scegli il genere");
        System.out.println("1 Fantascienza");
        System.out.println("2 Avventura");
        System.out.println("3 Biografia");
        System.out.println("4 Drammatico");

        Libro.Genere genere;
        genere = Libro.Genere.Fantascienza;
        switch (askInput()) {
            case 1:
                genere = Libro.Genere.Fantascienza;
                break;
            case 2:
                genere = Libro.Genere.Avventura;
                break;
            case 3:
                genere = Libro.Genere.Biografia;
                break;
            case 4:
                genere = Libro.Genere.Drammatico;
                break;
        }
        return genere;
    }

}