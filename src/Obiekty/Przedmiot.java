package Obiekty;

import java.util.ArrayList;

public class Przedmiot {
    String nazwa;
    ArrayList<Przedmiot> przedmioty;

    public Przedmiot(String nazwa, ArrayList<Przedmiot> przedmioty) {
        this.nazwa = nazwa;
        this.przedmioty = przedmioty;
    }
}
