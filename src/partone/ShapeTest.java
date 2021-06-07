package partone;

import partone.geometric.Quadrato;
import partone.geometric.Triangolo;
import partone.geometric.Trapezio;

import java.util.Scanner;

public class ShapeTest {

    /**
     * Scrivere un programma Java che esegua le seguenti operazioni:
     * 1. chiede all'utente per che tipo di forma geometrica desidera calcolare l'area
     * 2. le figure da trattare sono 3: Quadrato, Triangolo, Trapezio
     * 3. per la figura prescelta, chiede i parametri necessari al calcolo dell'area
     * 4. calcola l'area utilizzando l'apposita formula geometrica
     * 5. stampa il risultato
     *
     * Utilizzare per le parti di codice spcifiche di una figura tre classi,
     * implementando i relativi metodi come "static": Quadrato.java, Trapezio.java, Triangolo.java
     *
     * Per l'input utilizzare la classe Scanner; per discriminare tra le classi da chiamare usate un'istruzione switch
     */
    public static void main(String[] args) {
        System.out.println("Di quale forma vuoi calcolare l'area? ");
        System.out.println("1 = Quadrato");
        System.out.println("2 = Trapezio");
        System.out.println("3 = Triangolo");
        Scanner input = new Scanner(System.in);
        int scelta = input.nextInt();
        switch(scelta) {
            case 1:
                System.out.println("Inserisci il lato del quadrato:");
                double lato = input.nextDouble();
                System.out.println("L'area del quadrato è: " + Quadrato.computeArea(lato));
                break;
            case 2:
                System.out.println("Inserisci la base maggiore del trapezio:");
                double bmag = input.nextDouble();
                System.out.println("Inserisci la base minore:");
                double bmin = input.nextDouble();
                System.out.println("Inserisci l'altezza:");
                double alt = input.nextDouble();
                System.out.println("L'area del trapezio è:" + Trapezio.computeArea(bmag,bmin,alt));
                break;
            case 3:
                System.out.println("Inserisci la base del triangolo:");
                double base = input.nextDouble();
                System.out.println("Inserisci l'altezza del triangolo:");
                double altez = input.nextDouble();
                System.out.println("L'area del triangolo è:" + Triangolo.computeArea(base,altez));
                break;
          }
    }
}



