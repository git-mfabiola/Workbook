package partone.geometric;

public class Trapezio {
    // Area trapezio: (B + b) * A / 2
    public static double computeArea(double bmaj, double bmin, double height) {
        double area = (bmaj+bmin)*height/2;
        return area;
    }
}