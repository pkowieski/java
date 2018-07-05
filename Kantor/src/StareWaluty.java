
public class StareWaluty extends Waluta {

    public StareWaluty(String nazwaWaluty, String symbolWaluty, Double kursKupna, Double kursSprzedazy, Double iloscWkantorze) {
        super(nazwaWaluty, symbolWaluty, kursKupna, kursSprzedazy, iloscWkantorze);
        {
            System.out.println("Wywołano konstruktor starych walut.");
        }
    }

    @Override
    public void niszczWaluty() {
        System.out.println("Stare waluty dalej mają wartość.. na przykład dla kolekcjonerów. Nie niszczmy ich!");
    }

}

