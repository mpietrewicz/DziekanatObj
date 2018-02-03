package Obiekty;

import java.util.ArrayList;
import java.util.Map;

public class Student {
    String imie;
    String nazwisko;
    ArrayList<Grupa> grupy;
    Map<Przedmiot, Ocena> ocenayZaPrzedmioty;
    int punktyECTS = 0;
    static int liczbaPunktowECTSPotrzebnychDoZaliczenia = 30;
    String status = "Brak promocji";

    public Student(String imie, String nazwisko, ArrayList<Grupa> grupy, Map<Przedmiot, Ocena> ocenayZaPrzedmioty) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.grupy = grupy;
        this.ocenayZaPrzedmioty = ocenayZaPrzedmioty;
    }

    public Student(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString() {
        return "Student{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", grupy=" + grupy +
                ", ocenayZaPrzedmioty=" + ocenayZaPrzedmioty +
                ", punktyECTS=" + punktyECTS +
                ", status='" + status + '\'' +
                '}';
    }
}
