import Obiekty.Grupa;
import Obiekty.Nauczyciel;
import Obiekty.Przedmiot;
import Obiekty.Student;

import java.util.ArrayList;

public enum BazaDanych {
    INSTANCJA;

    public ArrayList<Student> listaStudentow = new ArrayList<>();
    public ArrayList<Nauczyciel> listaNauczycieli = new ArrayList<>();
    public ArrayList<Przedmiot> listaPrzedmiotow = new ArrayList<>();
    public ArrayList<Grupa> listaGrup = new ArrayList<>();

}
