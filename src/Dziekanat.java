import Obiekty.*;
import org.w3c.dom.ranges.Range;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
                            dodajStudenta(bazaDanych, bufferedReader);
                            break;
                        case "2":
                            System.out.println("<<<<<< Edytowanie >>>>>>");
                            break;
                        case "3":
                            System.out.println("<<<<<< Usuwanie >>>>>>");
                            break;
                        case "9":
                            wyswietlListe(bazaDanych.listaStudentow);
                            break;
                        default:
                            System.out.println("Operacja niedostępna!");
                            break;
                    }
                    break;


                case "2":
                    wyswietlMenuDoZarzadzania("Nauczycielami");
                    wybranaOperacja = bufferedReader.readLine();
                    switch (wybranaOperacja) {
                        case "1":
                            DodajNauczyciela(bazaDanych, bufferedReader);
                            break;
                        case "2":
                            System.out.println("<<<<<< Edytowanie >>>>>>");
                            break;
                        case "3":
                            System.out.println("<<<<<< Usuwanie >>>>>>");
                            break;
                        case "9":
                            wyswietlListe(bazaDanych.listaNauczycieli);
                            break;
                        default:
                            System.out.println("Operacja niedostępna!");
                            break;
                    }
                    break;


                case "3":
                    wyswietlMenuDoZarzadzania(" Grupami");
                    wybranaOperacja = bufferedReader.readLine();
                    switch (wybranaOperacja) {
                        case "1":
                            dodajGrupe(bazaDanych, bufferedReader);
                            break;
                        case "2":
                            System.out.println("<<<<<< Edytowanie >>>>>>");
                            break;
                        case "3":
                            System.out.println("<<<<<< Usuwanie >>>>>>");
                            break;
                        case "9":
                            wyswietlListe(bazaDanych.listaGrup);
                            break;
                        default:
                            System.out.println("Operacja niedostępna!");
                            break;
                    }
                    break;


                case "4":
                    wyswietlMenuDoZarzadzania("Przedmiotami");
                    wybranaOperacja = bufferedReader.readLine();
                    switch (wybranaOperacja) {
                        case "1":
                            dodajPrzedmiot(bazaDanych, bufferedReader);
                            break;
                        case "2":
                            if (bazaDanych.listaPrzedmiotow.size() == 0) {
                                System.out.println("");
                            }
                            else {
                                System.out.println("PRZEDMIOTY");
                                wyswietlListe(bazaDanych.listaPrzedmiotow);
                                System.out.println("Podaj id przedmiotu do edycji");
                                Integer wybranyId = Integer.parseInt(bufferedReader.readLine());
                                if (wybranyId >= 0 && wybranyId <= bazaDanych.listaPrzedmiotow.size()) {
                                    Przedmiot przedmiotDoEdycji = bazaDanych.listaPrzedmiotow.get(wybranyId);
                                    System.out.println("Podaj nową nazwę lub naciśniej Enter aby pozostawić bez zmian("+przedmiotDoEdycji.getNazwa()+")");
                                    String nazwa = bufferedReader.readLine();
                                    if (!nazwa.equals("")) {
                                        przedmiotDoEdycji.setNazwa(nazwa);
                                    }
                                }
                                else {
                                    System.out.println("Brak przedmiotu o podanym id");
                                }
                            }
                            System.out.println("<<<<<< Edytowanie >>>>>>");
                            break;
                        case "3":
                            System.out.println("<<<<<< Usuwanie >>>>>>");
                            break;
                        case "9":
                            wyswietlListe(bazaDanych.listaPrzedmiotow);
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

    private static void wyswietlMenuDoZarzadzania(String kontekstZarzadzania) {
        System.out.println("Zarządzanie "+kontekstZarzadzania);
        System.out.println("Możliwe operacje: \n 1. Dodaj \n 2. Edytuj \n 3. Usuń \n 9. Wyświetl Listę");
    }

    private static void dodajStudenta(BazaDanych bazaDanych, BufferedReader bufferedReader) throws IOException {
        System.out.print("Podaj imie: ");
        String imie = bufferedReader.readLine();
        System.out.print("Podaj nazwisko: ");
        String nazwisko = bufferedReader.readLine();
        Student nowyStudent = new Student(imie, nazwisko);
        bazaDanych.listaStudentow.add(nowyStudent);
    }

    private static void DodajNauczyciela(BazaDanych bazaDanych, BufferedReader bufferedReader) throws IOException {
        System.out.print("Podaj imie: ");
        String imie = bufferedReader.readLine();
        System.out.print("Podaj nazwisko: ");
        String nazwisko = bufferedReader.readLine();
        bazaDanych.listaNauczycieli.add(new Nauczyciel(imie, nazwisko));
    }



    private static void dodajGrupe(BazaDanych bazaDanych, BufferedReader bufferedReader) throws IOException {
        System.out.print("Podaj nazwę: ");
        String nazwa = bufferedReader.readLine();
        System.out.println("PRZEDMIOTY: ");
        if (bazaDanych.listaPrzedmiotow.size() == 0) {
            System.out.println("utworzenie nowej grupy!!!");
        }
        else {
            wyswietlListe(bazaDanych.listaPrzedmiotow);
            System.out.println("Wprowadź id przedmiotu lub utworz nowy przedmiot");
        }
    }

    private static void dodajPrzedmiot(BazaDanych bazaDanych, BufferedReader bufferedReader) throws IOException {
        System.out.print("Podaj nazwę: ");
        String nazwa = bufferedReader.readLine();
        bazaDanych.listaPrzedmiotow.add(new Przedmiot(nazwa));
    }


    private static void wyswietlListe(ArrayList lista) {
        int index = 0;
        for (Object obiekt : lista) {
            System.out.println(index+": "+obiekt);
            index++;
        }
    }

}
