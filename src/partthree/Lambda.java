package partthree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda {
    public static void main(String[] args) {
        // 1. Data una lista di nomi:
        //    - Agnese Stefano, Niki, Veronica, GabrieleM, Davide, GabrieleG, Alessandor, Albnerto, Fabiola, Alessio, Daniele
        //    - ...partire con un ArrayList che li contiene;
        //    - trasformarlo in stream
        //    - filtrare (escludendoli) i nomi che hanno lunghezza < 5 lettere
        //    - trasformare con UPPERCASE i rimanenti
        //    - stamparli su schermo
        //    ...concatenando il più possibile le varie operazioni

        List<String> nomi = new ArrayList<>(Arrays.asList("Agnese", "Stefano", "Niki", "Veronica", "GabrieleM",
                "Davide", "GabrieleG", "Alessandro", "Alberto", "Fabiola", "Alessio", "Daniele"));

        // trasformo l'arraylist in stream

        nomi
                .stream()
                .filter(s -> s.length() > 4)
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList())
                .forEach(s -> System.out.println(s));

        // 2. Fare un programma Java che:
        //    - chiede all'utente una lista di numeri (separati da virgola) <== RIUSATE IL CODICE DEL SORTING GAME
        //    - li trasforma in stream
        //    - filtra i duplicati (HINT: guardate bene i metodi dell'interfaccia Stream...)
        //    - eleva al quadrato i numeri filtrati
        //    - calcola la media (HINT: operazione terminale chiamata "average": https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/stream/IntStream.html#average())

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci lista di numeri separati da virgola: ");
        String input = scanner.nextLine();

        String[] strings = input.split(",");
        List<Integer> list = new ArrayList<>();

        for (String s : strings) {
            int i = Integer.parseInt(s);
            list.add(i);
        }

        list
                .stream()
                .distinct()
                .map(l -> l * l)
               // .average()
                .collect(Collectors.toList())
                .forEach(l -> System.out.println(l));

    }
}
