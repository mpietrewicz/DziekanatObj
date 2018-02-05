package Dziekanat;

public enum Kolory {
    CZERWONY,
    ZIELONY,
    PASKUDNY;

    int wartoscKoloru = 10;

    public Kolory getNazwaKoloru() {
        return this;
    }

    public static void main(String[] args) {
        System.out.println(Kolory.ZIELONY.wartoscKoloru);
        System.out.println(Kolory.ZIELONY.getNazwaKoloru());
    }
}

