package Dziekanat;

import Dziekanat.ObiektyDziekanatu.*;

import java.util.ArrayList;

public enum BazaDanych {
    INSTANCJA;

    public ArrayList<Student> listaStudentow = new ArrayList<>();
    public ArrayList<Nauczyciel> listaNauczycieli = new ArrayList<>();
    public java.util.ArrayList<Przedmiot> listaPrzedmiotow = new ArrayList<Przedmiot>();
    public ArrayList<Grupa> listaGrup = new ArrayList<>();

}
