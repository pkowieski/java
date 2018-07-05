import java.util.Arrays;
import java.util.Objects;

public class Kantor {

    public Waluta[] spisWalut;

    double przychodPLN;
    double przychodUSD;
    double przychodEUR;
    double przychodGBP;
    double przychodCHF;

    Kantor(int liczba) {
        spisWalut = new Waluta[liczba];
    }

    public void dodajWalute(Waluta waluta, int index) {
        spisWalut[index] = waluta;
    }

    public void wyswietlWaluty() {
        Arrays.asList(spisWalut).stream()
                .filter(Objects::nonNull)
                .forEach(Waluta::wyswietlWalute);
    }

    public void wyswietlStareWaluty() {
        for (int i = 0; i < spisWalut.length; i++) {
            spisWalut[i].wyswietlWalute();
            System.out.println();
        }
    }

    public void niszczenie() {
        for (Waluta waluta : spisWalut) {
            System.out.println(waluta);
            waluta.niszczWaluty();
        }
    }

    public void kupUSD(double ilosc) {
        if (ilosc < spisWalut[0].iloscWkantorze)
            przychodPLN += spisWalut[0].kursKupna * ilosc;
        else System.out.println("Nie mamy takiej ilosci w kantorze!");
    }

    public void kupEUR(double ilosc) {
        if (ilosc < spisWalut[1].iloscWkantorze)
            przychodPLN += spisWalut[1].kursKupna * ilosc;
        else System.out.println("Nie mamy takiej ilosci w kantorze!");
    }

    public void kupGBP(double ilosc) {
        if (ilosc < spisWalut[2].iloscWkantorze)
        przychodPLN += spisWalut[2].kursKupna * ilosc;
        else System.out.println("Nie mamy takiej ilosci w kantorze!");
    }

    public void kupCHF(double ilosc) {
        if (ilosc < spisWalut[3].iloscWkantorze)
            przychodPLN += spisWalut[3].kursKupna * ilosc;
        else System.out.println("Nie mamy takiej ilosci w kantorze!");
    }

    public void sprzedajUSD(double ilosc) {
        przychodUSD += ilosc;
        spisWalut[0].iloscWkantorze += spisWalut[0].iloscWkantorze;
    }

    public void sprzedajEUR(double ilosc) {
        przychodEUR += ilosc;
        spisWalut[1].iloscWkantorze += spisWalut[1].iloscWkantorze;
    }

    public void sprzedajGBP(double ilosc) {
        przychodGBP += ilosc;
        spisWalut[2].iloscWkantorze += spisWalut[2].iloscWkantorze;
    }

    public void sprzedajCHF(double ilosc) {
        przychodCHF += ilosc;
        spisWalut[3].iloscWkantorze += spisWalut[3].iloscWkantorze;
    }
}