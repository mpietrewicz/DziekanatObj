package Dziekanat.ObiektyDziekanatu;

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

    public Nauczyciel(String imie, String nazwisko, Przedmiot przedmiot) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        setPrzedmiot(przedmiot);
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public ArrayList<Przedmiot> getPrzedmioty() {
        return przedmioty;
    }

    public void setPrzedmioty(ArrayList<Przedmiot> przedmioty) {
        this.przedmioty = przedmioty;
    }

    public void setPrzedmiot(Przedmiot przedmiot) {
        this.przedmioty = new ArrayList<>();
        this.przedmioty.add(przedmiot);
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
