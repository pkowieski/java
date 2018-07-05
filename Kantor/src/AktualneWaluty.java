
public class AktualneWaluty extends Waluta {

    public AktualneWaluty(String nazwaWaluty, String symbolWaluty, Double kursKupna, Double kursSprzedazy) {
        super(nazwaWaluty, symbolWaluty, kursKupna, kursSprzedazy);
        {
            System.out.println("Wywołano konstruktor aktualnych walut. Liczba obiektów: " + zwrocLiczbeObiektow());
        }
    }

    @Override
    public void niszczWaluty() {
        System.out.println("Nie można niszczyć pieniędzy!");
    }

}
