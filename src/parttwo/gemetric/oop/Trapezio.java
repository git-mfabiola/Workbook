package parttwo.gemetric.oop;

import parttwo.gemetric.oop.MasterShape;

public class Trapezio extends MasterShape {
    private double bmin;
    private double bmaj;
    private double height;
    private double lato;

    public Trapezio(double bmin, double bmaj, double height, double lato) {
        this.bmin = bmin;
        this.bmaj = bmaj;
        this.height = height;
        this.lato = lato;
    }

    public double getBmin() {
        return bmin;
    }

    public void setBmin(double bmin) {
        this.bmin = bmin;
    }

    public double getBmaj() {
        return bmaj;
    }

    public void setBmaj(double bmaj) {
        this.bmaj = bmaj;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLato() {
        return lato;
    }

    public void setLato(double lato) {
        this.lato = lato;
    }

    @Override
    public double computeArea() {
        return (bmaj+bmin) * height /2;
    }

    @Override
    public double computePerimeter() {
        return (bmaj + bmin + height) + lato;
    }
}
