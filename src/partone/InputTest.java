package partone;

import java.util.Scanner;

public class InputTest {
    public static void main(String[] args) {
        Scanner in;
        in=new Scanner(System.in);

        //Chiedo inserimento il primo numero
        System.out.println("Inserisci un numero:");
        int n1 = in.nextInt();
        String indexn1 = "primo";
        System.out.println("Hai inserito il numero:" + n1);

        //Chiedo il secondo numero
        System.out.println("Inserisci un numero:");
        int n2 = in.nextInt();
        String indexn2 = "secondo";
        System.out.println("Hai inserito il numero:" + n2);

        //Chiedo il terzo numero
        System.out.println("Inserisci un numero:");
        int n3 = in.nextInt();
        String indexn3 = "terzo";
        System.out.println("Hai inserito il numero:" + n3);

        if (n1>=n2 && n1>=n3)
            System.out.println("il " + indexn1 +" numero è il maggiore : " + n1);
        else if (n2>=n3)
            System.out.println("il " + indexn2 +" numero è il maggiore : " + n2);
        else
            System.out.println("il " + indexn3 +" numero è il maggiore : " + n3);
    }
}
