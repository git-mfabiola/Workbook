package parttwo.gemetric.oop;

import parttwo.gemetric.oop.MasterShape;

public class Quadrato extends MasterShape {
    private double l;

    public Quadrato(double l) {
        this.l = l;
    }

    public double getL() {
        return l;
    }

    public void setL(double l) {
        this.l = l;
    }

    @Override
    public double computeArea() {
        return l*l;
    }

    @Override
    public double computePerimeter() {
        return l*4;
    }

}
