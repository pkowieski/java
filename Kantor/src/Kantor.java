import java.util.Arrays;
import java.util.Objects;

public class Kantor {

    private Waluta[] spisWalut;

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
        przychodPLN += spisWalut[0].kursKupna * ilosc;
    }

    public void kupEUR(double ilosc) {
        przychodPLN += spisWalut[1].kursKupna * ilosc;
    }

    public void kupGBP(double ilosc) {
        przychodPLN += spisWalut[2].kursKupna * ilosc;
    }

    public void kupCHF(double ilosc) {
        przychodPLN += spisWalut[3].kursKupna * ilosc;
    }

    public void sprzedajUSD(double ilosc) {
        przychodUSD += ilosc;
    }

    public void sprzedajEUR(double ilosc) {
        przychodEUR += ilosc;
    }

    public void sprzedajGBP(double ilosc) {
        przychodGBP += ilosc;
    }

    public void sprzedajCHF(double ilosc) {
        przychodCHF += ilosc;
    }
}