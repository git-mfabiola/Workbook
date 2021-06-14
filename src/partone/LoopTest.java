package partone;

import java.util.Scanner;

public class LoopTest {
    public static void main(String[] args)
    {
        int i, j, n;
        int incr = 1;

        System.out.print("Input number of rows : ");
        Scanner theScan = new Scanner(System.in);
        n = theScan.nextInt();

        for(i = 1; i <= n; i++) {
            // System.out.println("Sono alla riga ==> " + i);
            for(j = 1; j <= i; j++) {
                //System.out.print(j);
                System.out.print(incr + " ");
                incr++;
            }
            System.out.println("");
        }
    }
}
