package Obiekty;

import java.util.ArrayList;

public class Grupa {
    String nazwa;
    ArrayList<Przedmiot> przedmioty;

    public Grupa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Grupa(String nazwa, ArrayList<Przedmiot> przedmioty) {
        this.nazwa = nazwa;
        this.przedmioty = przedmioty;
    }
}
