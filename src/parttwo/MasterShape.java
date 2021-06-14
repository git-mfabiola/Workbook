package parttwo;

public class MasterShape {

    // 1. Create una classe "MasterShape" che sarà la classe "parent"

    // 2. all'interno di "MasterShape" definite il metodo computeArea
    //    e il metodo il metodo computePerimeter, che NON devono ricevere
    //    argomenti in input: questi metodi devono restituire 0.0

    // 3. Usate i costruttori specifici delle classi figlie per richiedere
    //    al momento della creazione i parametri che servono per fare i
    //    calcoli in ciascuna forma geometrica

    // 4. Le classi figle (Trapezio, Triangolo, Quadrato) devono ESTENDERE
    //    (con "extends") la MasterShape e implementare l'OVERRIDE dei metodi
    //    computeArea e computePerimeter (nota: aggiungere l'annotation @Override)

    // 5. Create una classe Tester con il metodo main(String[] args), all'interno
    //    del quale dovrete:
    //    - creare 3 forme geometriche diverse, come istanze delle classi figlie: chiedete
    //      i dati in input nel metodo main e salvateli nelle proprietà interne
    //      di ciascuna classe
    //    - creare un array di MasterShape che avrà come elementi le istanze create
    //    - calcolare le aree e stamparle in un unico loop (come "ilConto")

    public double computeArea(){
        return 0.0;
    }
    public double computePerimeter(){
        return 0.0;
    }
}


