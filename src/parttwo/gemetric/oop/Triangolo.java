package parttwo.gemetric.oop;

import parttwo.gemetric.oop.MasterShape;

public class Triangolo extends MasterShape {
    private double base;
    private double altez;

    public Triangolo(double base, double altez) {
        this.base = base;
        this.altez = altez;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltez() {
        return altez;
    }

    public void setAltez(double altez) {
        this.altez = altez;
    }

    @Override
    public double computeArea() {
        return base * altez/2;
    }

    @Override
    public double computePerimeter() {
        return altez + 2 * base;
    }
}
