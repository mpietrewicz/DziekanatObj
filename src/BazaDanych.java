import Obiekty.Nauczyciel;
import Obiekty.Student;

import java.util.ArrayList;

public enum BazaDanych {
    INSTANCJA;

    public ArrayList<Student> listaStudentow = new ArrayList<>();
    public ArrayList<Nauczyciel> listaNauczycieli = new ArrayList<>();

}
