package parttwo.corsostudenti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseTest {

    // 1. Studenti e corsi
    //
    //    Creare le seguenti classi:
    //    - Student (nome, cognome, codiceStudente, tutti String)
    //    - Course (titolo, descrizione, settore)
    //    - Assignment (titolo, descrizione)
    //
    //    Create anche i dati di almeno:
    //    - 3 studenti
    //    - 3 corsi
    //    - un corso ha 2 o + assignment, ciascun studente esegue tutti gli assignment ricevendo un voto da 1 a 10
    //
    //    Caricate tutti i dati in un'unica collection, organizzata in modo da poter contenere tutti i voti presi
    //    da ciascuno studente.
    //
    //    Calcolate con questa struttura:
    //    - la media dei voti di ciascun studente in ciascun corso (come è andato ciascun studente in un corso?)
    //    - la media dei voti di tutti gli studenti in ciascun assignment (quanto è difficile per gli studenti
    //      un certo assignment?)

    public static void main(String[] args) {
        Student qui = new Student("Qui", "Ciao", "202654");
        Student quo = new Student("Quo", "Ciao", "500059");
        Student qua = new Student("Qua", "Ciao", "521845");

        Course medicina = new Course("medicina", "anatomia 2 corso avanzato", "umanitario");
        Course matematica = new Course("matematica", "matematica applicata", "scientifico");
        Course arte = new Course("storia del arte", "Barocco", "artistico");

        Assignment tema = new Assignment ("tema","scrivi tema");
        Assignment equaz = new Assignment ("equazione", "risolvi equazione");
        Assignment basso = new Assignment ("bassorilievo", " creare bassorilievo");
        Assignment dipinto = new Assignment ("dipingi","dipingi natura morta");

        Map<Assignment, Map<Student,Float>> medassignment = new HashMap<>();
        medassignment.put(tema, studentievoti(qui, 6f, quo, 7f, qua, 8f));
        medassignment.put(equaz, studentievoti(qui, 3f, quo, 2f, qua, 1f));

        Map<Assignment, Map<Student,Float>> matassignment = new HashMap<>();
        matassignment.put(tema, studentievoti(qui, 7f, quo, 8f, qua, 6f));
        matassignment.put(equaz, studentievoti(qui, 5f, quo, 3f, qua, 9f));

        Map<Assignment, Map<Student,Float>> arteassignment = new HashMap<>();
        arteassignment.put(tema, studentievoti(qui, 3f, quo, 5f, qua, 6.5f));
        arteassignment.put(basso, studentievoti(qui, 7.4f, quo, 8f, qua, 10f));
        arteassignment.put(dipinto, studentievoti(qui, 6f, quo, 7f, qua, 8f));

        Map<Course, Map<Assignment, Map<Student,Float>>> corsi = new HashMap<>();
        corsi.put(medicina, medassignment);
        corsi.put(matematica, matassignment);
        corsi.put(arte, arteassignment);

        calcolomediastudenticorso(corsi);
    }

    public static Map<Student, Float> studentievoti(
            Student st1, Float voto1,
            Student st2, Float voto2,
            Student st3, Float voto3) {

        Map<Student, Float> studentievoti = new HashMap<>();
        studentievoti.put(st1,voto1);
        studentievoti.put(st2,voto2);
        studentievoti.put(st3,voto3);
        return studentievoti;
    }

    public static void calcolomediastudenticorso(Map<Course, Map<Assignment, Map<Student,Float>>> corsi){

        for (Course corso : corsi.keySet()) {
            Float totvotiqui = 0f;
            Float totvotiquo = 0f;
            Float totvotiqua = 0f;

            Map<Assignment, Map<Student,Float>> assignements = corsi.get(corso);

            for (Assignment assignment: assignements.keySet() ) {

                Map<Student,Float> studenti = assignements.get(assignment);

                for (Student studente : studenti.keySet() ) {
                    if (studente.getNome().equalsIgnoreCase("qui")){
                        totvotiqui = totvotiqui + studenti.get(studente);
                    } else if (studente.getNome().equalsIgnoreCase("quo")) {
                        totvotiquo = totvotiquo + studenti.get(studente);
                    } else if (studente.getNome().equalsIgnoreCase("qua")) {
                        totvotiqua = totvotiqua + studenti.get(studente);
                    }
                }
            }

            System.out.println("la media dei voti del corso "+ corso.getTitolo() + " di Qui è: " + (totvotiqui/ assignements.size()));
            System.out.println("la media dei voti del corso "+ corso.getTitolo() + " di Quo è: " + (totvotiquo/ assignements.size()));
            System.out.println("la media dei voti del corso "+ corso.getTitolo() + " di Qua è: " + (totvotiqua/ assignements.size()));
        }
    }

    public static void calcolomediastudentiassignment(Map<Course, Map<Assignment, Map<Student,Float>>> corsi){
        //    - la media dei voti di tutti gli studenti in ciascun assignment (quanto è difficile per gli studenti
        //      un certo assignment?)
        Float totassignment = 0f;
        for (Course corso : corsi.keySet()) {

            Map<Assignment, Map<Student,Float>> assignements = corsi.get(corso);

            for (Assignment assignment: assignements.keySet() ) {

                Map<Student,Float> studenti = assignements.get(assignment);

                for (Student studente : studenti.keySet() ) {
                   totassignment = totassignment + studenti.get(studente);
                }
            }
        }
    }
}
