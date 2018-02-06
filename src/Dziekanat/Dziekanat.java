package Dziekanat;

import Dziekanat.ObiektyDziekanatu.*;

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
                    zarzadzajStudentami(bazaDanych, bufferedReader);
                    break;
                case "2":
                    zarzadzajNauczycielami(bazaDanych, bufferedReader);
                    break;
                case "3":
                    zarzadzajGrupami(bazaDanych, bufferedReader);
                    break;
                case "4":
                    zarzadzajPrzedmiotami(bazaDanych, bufferedReader);
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


    private static void zarzadzajPrzedmiotami(BazaDanych bazaDanych, BufferedReader bufferedReader) throws IOException {
        String wybranaOperacja;
        wyswietlMenuDoZarzadzania("Przedmiotami");
        wybranaOperacja = bufferedReader.readLine();
        switch (wybranaOperacja) {
            case "1":
                dodajPrzedmiot(bazaDanych, bufferedReader);
                break;
            case "2":
                edytujPrzedmiot(bazaDanych, bufferedReader);
                break;
            case "3":
                UsunPrzedmiot(bazaDanych, bufferedReader);
                break;
            case "9":
                wyswietlListeObiektow(bazaDanych.listaPrzedmiotow);
                break;
            default:
                System.out.println("Operacja niedostępna!");
                break;
        }
    }

    private static void UsunPrzedmiot(BazaDanych bazaDanych, BufferedReader bufferedReader) throws IOException {
        if (bazaDanych.listaPrzedmiotow.size() == 0) {
            System.out.println("Brak przedmiotów do edycji");
        }
        else {
            System.out.println("PRZEDMIOTY");
            wyswietlListeObiektow(bazaDanych.listaPrzedmiotow);
            System.out.println("Podaj id przedmiotu do usunięcia");
            Integer wybranyId = Integer.parseInt(bufferedReader.readLine());
            if (wybranyId >= 0 && wybranyId <= bazaDanych.listaPrzedmiotow.size()) {
                bazaDanych.listaPrzedmiotow.remove(wybranyId-1);
            }
            else {
                System.out.println("Brak przedmiotu o podanym id");
            }
        }
    }

    private static Przedmiot edytujPrzedmiot(BazaDanych bazaDanych, BufferedReader bufferedReader) throws IOException {
        int indexObiektu = wyborObiektuDoEdycji(bazaDanych, bufferedReader, bazaDanych.listaPrzedmiotow);
        if (indexObiektu != 0) {
            Przedmiot przedmiotDoEdycji = bazaDanych.listaPrzedmiotow.get(indexObiektu-1);
            przedmiotDoEdycji.setNazwa(pobierzNowaWartoscPola(bufferedReader, "nazwa", przedmiotDoEdycji.getNazwa()));
            return przedmiotDoEdycji;
        }
        return null;
    }

    private static void edytujNauczyciela(BazaDanych bazaDanych, BufferedReader bufferedReader) throws IOException {
        int indexObiektu = wyborObiektuDoEdycji(bazaDanych, bufferedReader, bazaDanych.listaNauczycieli);
        if (indexObiektu != 0) {
            Nauczyciel nauczycielDoEdycji = bazaDanych.listaNauczycieli.get(indexObiektu-1);
            nauczycielDoEdycji.setImie(pobierzNowaWartoscPola(bufferedReader, "imie", nauczycielDoEdycji.getImie()));
            nauczycielDoEdycji.setNazwisko(pobierzNowaWartoscPola(bufferedReader, "nazwisko", nauczycielDoEdycji.getNazwisko()));
            if(nauczycielDoEdycji.getPrzedmioty().size() > 0) {
                wyswietlListeObiektow(nauczycielDoEdycji.getPrzedmioty());
                System.out.println("Czy chczesz edytować obecną listę przedmiotów czy dodać nowy?");
                Przedmiot edytowanyPrzedmiot = edytujPrzedmiot(bazaDanych, bufferedReader);
                if(edytowanyPrzedmiot != null) {
                    nauczycielDoEdycji.setPrzedmiot(edytowanyPrzedmiot);
                }
            }
            else {
                nauczycielDoEdycji.setPrzedmiot(dodajPrzedmiot(bazaDanych, bufferedReader));
            }
        }
    }

    private static String pobierzNowaWartoscPola(BufferedReader bufferedReader, String nazwaPola, String obecnaWartoscPola) throws IOException {
        System.out.println("Podaj " +nazwaPola +" lub naciśniej Enter aby pozostawić bez zmian("+ obecnaWartoscPola+")");
        String nowaWartoscPola = bufferedReader.readLine();
        if (!nowaWartoscPola.equals("")) {
            return nowaWartoscPola;
        } else {
            return obecnaWartoscPola;
        }
    }

    private static int wyborObiektuDoEdycji(BazaDanych bazaDanych, BufferedReader bufferedReader, ArrayList listaObiektow) throws IOException {
        if (listaObiektow.size() == 0) {
            System.out.println("Brak obiektow do edycji");
            return 0;
        }
        else {
            wyswietlListeObiektow(listaObiektow);
            System.out.println("Podaj id obiektu do edycji");
            Integer wybranyIdObiektu = Integer.parseInt(bufferedReader.readLine());
            if (wybranyIdObiektu >= 0 && wybranyIdObiektu <= listaObiektow.size()) {
                return wybranyIdObiektu;
            }
            else {
                System.out.println("Brak przedmiotu o podanym id");
                return 0;
            }
        }
    }

    private static void zarzadzajGrupami(BazaDanych bazaDanych, BufferedReader bufferedReader) throws IOException {
        String wybranaOperacja;
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
                wyswietlListeObiektow(bazaDanych.listaGrup);
                break;
            default:
                System.out.println("Operacja niedostępna!");
                break;
        }
    }

    private static void zarzadzajNauczycielami(BazaDanych bazaDanych, BufferedReader bufferedReader) throws IOException {
        String wybranaOperacja;
        wyswietlMenuDoZarzadzania("Nauczycielami");
        wybranaOperacja = bufferedReader.readLine();
        switch (wybranaOperacja) {
            case "1":
                dodajNauczyciela(bazaDanych, bufferedReader);
                break;
            case "2":
                edytujNauczyciela(bazaDanych, bufferedReader);
                break;
            case "3":
                System.out.println("<<<<<< Usuwanie >>>>>>");
                break;
            case "9":
                wyswietlListeObiektow(bazaDanych.listaNauczycieli);
                break;
            default:
                System.out.println("Operacja niedostępna!");
                break;
        }
    }

    private static void zarzadzajStudentami(BazaDanych bazaDanych, BufferedReader bufferedReader) throws IOException {
        String wybranaOperacja;
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
                wyswietlListeObiektow(bazaDanych.listaStudentow);
                break;
            default:
                System.out.println("Operacja niedostępna!");
                break;
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

    private static void dodajNauczyciela(BazaDanych bazaDanych, BufferedReader bufferedReader) throws IOException {
        System.out.print("Podaj imie: ");
        String imie = bufferedReader.readLine();
        System.out.print("Podaj nazwisko: ");
        String nazwisko = bufferedReader.readLine();
        Przedmiot przedmiot = dodajPrzedmiot(bazaDanych, bufferedReader);
        bazaDanych.listaNauczycieli.add(new Nauczyciel(imie, nazwisko, przedmiot));
    }



    private static void dodajGrupe(BazaDanych bazaDanych, BufferedReader bufferedReader) throws IOException {
        System.out.print("Podaj nazwę: ");
        String nazwa = bufferedReader.readLine();
        System.out.println("PRZEDMIOTY: ");
        if (bazaDanych.listaPrzedmiotow.size() == 0) {
            System.out.println("utworzenie nowej grupy!!!");
        }
        else {
            wyswietlListeObiektow(bazaDanych.listaPrzedmiotow);
            System.out.println("Wprowadź id przedmiotu lub utworz nowy przedmiot");
        }
    }

    private static Przedmiot dodajPrzedmiot(BazaDanych bazaDanych, BufferedReader bufferedReader) throws IOException {
        System.out.print("Podaj nazwę przedmiotu: ");
        String nazwa = bufferedReader.readLine();
        Przedmiot przedmiot = new Przedmiot(nazwa);
        bazaDanych.listaPrzedmiotow.add(przedmiot);
        return przedmiot;
    }


    private static void wyswietlListeObiektow(ArrayList lista) {
        int index = 1;
        for (Object obiekt : lista) {
            System.out.println(index+": "+obiekt);
            index++;
        }
    }

}
