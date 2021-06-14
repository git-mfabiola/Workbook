package partone;

public class LoopTestTwo {
    public static void main(String[] args) {
            /*
        VARIAZIONE: per d = 7
              1
             212
            32123
           4321234
          543212345
         65432123456
        7654321234567
         65432123456
          543212345
           4321234
            32123
             212
              1
     */
        int i, j, d;
        // d viene in input
        d = 7;
        // LOOP ORIGINALE
        for (i = 1; i <= d; i++) {
            // Stampo gli spazi
            int numSpaces = d - i;
            for (j = 1; j <= numSpaces; j++) {
                System.out.print(" ");
            }

            // Stampo le stelle
            int numStars = (2 * i) - 1;
            for (j = 1; j <= numStars; j++) {   //13
                System.out.print("*");
            }

            System.out.println("");
        }

        for (i = d - 1; i >= 1; i--) {
            // Stampo gli spazi
            int numSpaces = d - i;
            for (j = 1; j <= numSpaces; j++) {
                System.out.print(" ");
            }

            // Stampo le stelle
            int numStars = (2 * i) - 1;
            for (j = 1; j <= numStars; j++) {
                System.out.print("*");
            }

            System.out.println("");
        }
    }
}