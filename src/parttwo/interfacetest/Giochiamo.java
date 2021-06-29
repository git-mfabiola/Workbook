package parttwo.interfacetest;

public class Giochiamo {
    public static void main (String args[]) {

        Eroe e = new Eroe();
        Licantropo l = new Licantropo(true);
        Vampiro v = new Vampiro();

        for (int i = 0; i < 3; i++) {
            e.combatti();
            v.azzanna();
            l.azzanna();
        }
        System.out.println(v.getForza());
        System.out.println(l.getForza());
        System.out.println(e.getForza());

    }
}
