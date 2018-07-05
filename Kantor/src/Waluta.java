
public abstract class Waluta {

    public String nazwaWaluty;
    public String symbolWaluty;
    public Double kursKupna;
    public Double kursSprzedazy;
    public Double iloscWkantorze;
    private static int liczbaObiektow = 0;

    protected Waluta(String nazwaWaluty, String symbolWaluty, double kursKupna, double kursSprzedazy, double iloscWkantorze) {

        this.nazwaWaluty = nazwaWaluty;
        this.symbolWaluty = symbolWaluty;
        this.kursKupna = kursKupna;
        this.kursSprzedazy = kursSprzedazy;
        this.iloscWkantorze = iloscWkantorze;
        liczbaObiektow++;
        System.out.println("Konstruktor klasy Waluta");
    }

    protected Waluta(Waluta waluta) {

        this.nazwaWaluty = waluta.nazwaWaluty;
        this.symbolWaluty = waluta.symbolWaluty;
        this.kursKupna = waluta.kursKupna;
        this.kursSprzedazy = waluta.kursSprzedazy;
        this.iloscWkantorze = waluta.iloscWkantorze;
        System.out.println("Konstruktor kopiujący");
    }

    public void wyswietlWalute() {
        System.out.println("Nazwa waluty: " + nazwaWaluty);
        System.out.println("Symbol waluty: " + symbolWaluty);
        System.out.println("Kurs kupna: " + kursKupna);
        System.out.println("Kurs sprzedaży: " + kursSprzedazy);
        System.out.println();
    }

    public abstract void niszczWaluty();

    public static int zwrocLiczbeObiektow() {
        return liczbaObiektow;
    }
}


