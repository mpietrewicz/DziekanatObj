import Obiekty.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dziekanat {

    public static void main(String[] args) throws IOException {

        BazaDanych bazaDanych = BazaDanych.INSTANCJA;

        while(true) {
            System.out.println("Zarządzaj: \n 1. Studentami \n 2. Nauczycielami \n 3. Grupami \n 4. Przedmiotami \n 5. Ocenami");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String wybranyKontekstObiektu = bufferedReader.readLine();
            String wybranaOperacja;
            switch (wybranyKontekstObiektu) {
                case "1":
                    System.out.println("Możliwe operacje: \n 1. Dodaj \n 2. Edytuj \n 3. Usuń \n 9. Wyświetl Listę");
                    wybranaOperacja = bufferedReader.readLine();
                    switch (wybranaOperacja) {
                        case "1":
                            System.out.print("Podaj imie: ");
                            String imie = bufferedReader.readLine();
                            System.out.print("Podaj nazwisko: ");
                            String nazwisko = bufferedReader.readLine();
                            Student nowyStudent = new Student(imie, nazwisko);
                            bazaDanych.listaStudentow.add(nowyStudent);
                            break;
                        case "2":
                            System.out.println("<<<<<< Edytowanie >>>>>>");
                            break;
                        case "3":
                            System.out.println("<<<<<< Usuwanie >>>>>>");
                            break;
                        case "9":
                            int index = 0;
                            for (Student student : bazaDanych.listaStudentow) {
                                System.out.println(index+": "+student);
                                index++;
                            }

                            break;
                        default:
                            System.out.println("Operacja niedostępna!");
                            break;
                    }
                    break;


                case "2":
                    System.out.println("<<< Zarządzanie Nauczycielami >>>");
                    System.out.println("Możliwe operacje: \n 1. Dodaj \n 2. Edytuj \n 3. Usuń \n 9. Wyświetl Listę");
                    wybranaOperacja = bufferedReader.readLine();
                    switch (wybranaOperacja) {
                        case "1":
                            System.out.print("Podaj imie: ");
                            String imie = bufferedReader.readLine();
                            System.out.print("Podaj nazwisko: ");
                            String nazwisko = bufferedReader.readLine();
                            bazaDanych.listaNauczycieli.add(new Nauczyciel(imie, nazwisko));
                            break;
                        case "2":
                            System.out.println("<<<<<< Edytowanie >>>>>>");
                            break;
                        case "3":
                            System.out.println("<<<<<< Usuwanie >>>>>>");
                            break;
                        case "9":
                            int index = 0;
                            for (Nauczyciel nauczyciel : bazaDanych.listaNauczycieli) {
                                System.out.println(index+": "+nauczyciel);
                                index++;
                            }
                            break;
                        default:
                            System.out.println("Operacja niedostępna!");
                            break;
                    }
                    break;


                case "3":
                    System.out.println("<<< Zarządzanie Grupami >>>");
                    System.out.println("Możliwe operacje: \n 1. Dodaj \n 2. Edytuj \n 3. Usuń \n 9. Wyświetl Listę");
                    wybranaOperacja = bufferedReader.readLine();
                    switch (wybranaOperacja) {
                        case "1":
                            System.out.print("Podaj nazwę: ");
                            String nazwa = bufferedReader.readLine();
                            System.out.println("PRZEDMIOTY: ");
                            int index1 = 0;
                            for (Przedmiot przedmiot : bazaDanych.listaPrzedmiotow) {
                                System.out.println(index1+": "+przedmiot);
                                index1++;
                            }
                            if (index1 == 0) {
                                System.out.println("utworzenie nowej grupy!!!");
                            }
                            else {
                                System.out.println("Wprowadź id przedmiotu lub utworz nowy przedmiot");
                            }
                            break;
                        case "2":
                            System.out.println("<<<<<< Edytowanie >>>>>>");
                            break;
                        case "3":
                            System.out.println("<<<<<< Usuwanie >>>>>>");
                            break;
                        case "9":
                            int index = 0;
                            for (Grupa grupa: bazaDanych.listaGrup) {
                                System.out.println(index+": "+grupa);
                                index++;
                            }
                            break;
                        default:
                            System.out.println("Operacja niedostępna!");
                            break;
                    }
                    break;


                case "4":
                    System.out.println("<<< Zarządzanie Przedmiotami >>>");
                    System.out.println("Możliwe operacje: \n 1. Dodaj \n 2. Edytuj \n 3. Usuń \n 9. Wyświetl Listę");
                    wybranaOperacja = bufferedReader.readLine();
                    switch (wybranaOperacja) {
                        case "1":
                            System.out.print("Podaj nazwę: ");
                            String nazwa = bufferedReader.readLine();
                            bazaDanych.listaPrzedmiotow.add(new Przedmiot(nazwa));
                            break;
                        case "2":
                            System.out.println("<<<<<< Edytowanie >>>>>>");
                            break;
                        case "3":
                            System.out.println("<<<<<< Usuwanie >>>>>>");
                            break;
                        case "9":
                            int index = 0;
                            for (Przedmiot przedmiot : bazaDanych.listaPrzedmiotow) {
                                System.out.println(index+": "+przedmiot);
                                index++;
                            }
                            break;
                        default:
                            System.out.println("Operacja niedostępna!");
                            break;
                    }
                    break;


                case "5":
                    System.out.println("<<< Zarządzanie Ocenami >>>");
                    break;


                default:
                    System.out.println("Zarzadanie niedostępna!");
                    break;
            }
        }
    }
}
