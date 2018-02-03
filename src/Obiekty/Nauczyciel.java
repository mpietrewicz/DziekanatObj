package Obiekty;

import java.util.ArrayList;

public class Nauczyciel {
    String imie;
    String nazwisko;
    ArrayList<Przedmiot> przedmioty;

    public Nauczyciel(String imie, String nazwisko, ArrayList<Przedmiot> przedmioty) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.przedmioty = przedmioty;
    }

    public Nauczyciel(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString() {
        return "Nauczyciel{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", przedmioty=" + przedmioty +
                '}';
    }
}
