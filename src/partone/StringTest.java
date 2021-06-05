package partone;

public class StringTest {
    public static void main(String[] args) {
        // Scrivere un programma in Java che:
        // 1. accetta in input 3 stringhe (da riga di comando)
        // 2. verifica che le stringhe siano 3
        // 3. calcola la lunghezza di ciascuna stringa
        // 4. trova il carattere iniziale e finale di ciascuna stringa
        // 5. per tutte e 3 le stringhe stampa un report:
        // "La stringa " .... " ha lunghezza " .... " comincia per " ... " e fniisce per " ...
        if (args.length == 3) {
            System.out.println("La stringa " + args[0] + " ha lunghezza " + args[0].length()+ " comincia per "+args[0].charAt(0)+" e finisce per "+args[0].charAt(args[0].length()-1));
            System.out.println("La stringa " + args[1] + " ha lunghezza " + args[1].length()+ " comincia per "+args[1].charAt(0)+" e finisce per "+args[1].charAt(args[1].length()-1));
            System.out.println("La stringa " + args[2] + " ha lunghezza " + args[2].length()+ " comincia per "+args[2].charAt(0)+" e finisce per "+args[2].charAt(args[2].length()-1));
        }
        else {
            System.out.println("errore");
         }
    }
}