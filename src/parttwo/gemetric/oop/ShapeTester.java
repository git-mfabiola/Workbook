package parttwo.gemetric.oop;

import java.util.Scanner;

public class ShapeTester {
    public static void main (String [] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("inserisci il lato del quadrato");
        double l = in.nextDouble();
        Quadrato quad1 = new Quadrato(l);

        System.out.println("inserisci la base del triangolo");
        double base = in.nextDouble();
        System.out.println("inserisci l'altezza del triangolo");
        double altezza = in.nextDouble();

        Triangolo tri1 = new Triangolo(base, altezza);

        System.out.println("inserisci la base minore del trapezio");
        double basemin = in.nextDouble();
        System.out.println("inserisci la base maggiore del trapezio");
        double basemag = in.nextDouble();
        System.out.println("inserisci l'altezza del trapezio");
        double altezzatra = in.nextDouble();
        System.out.println("inserisci lato del trapezio");
        double lato = in.nextDouble();

        Trapezio tra1 = new Trapezio(basemin, basemag, altezzatra, lato);

        MasterShape[] forme= new MasterShape[3];
        forme[0] = quad1;
        forme[1] = tri1;
        forme[2] = tra1;

        for (int i = 0; i < forme.length; i++) {
            System.out.println("l' area è " + forme[i].computeArea());
        }
    }
}
