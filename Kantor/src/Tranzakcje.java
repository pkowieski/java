import java.io.IOException;
import java.io.FileWriter;

public class Tranzakcje {

    private static int ilosc = 0;

    public void iloscTranzakcji() {
        ++ilosc;
    }

    public void pokazIloscTranzakcji() {
        System.out.println("Ilość tranzakcji = " + ilosc);
    }

    public void zestawieniePrzychodow(Kantor kantor) {
        System.out.println("Przychody PLN = " + kantor.przychodPLN);
        System.out.println("Przychody USD = " + kantor.przychodUSD);
        System.out.println("Przychody EUR = " + kantor.przychodEUR);
        System.out.println("Przychody GBP = " + kantor.przychodGBP);
        System.out.println("Przychody CHF = " + kantor.przychodCHF);
    }

    public static void zapiszTranzakcje(Kantor kantor) throws IOException {
        String sciezka = "tranzakcje.txt";
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(sciezka);
            fileWriter.write("Ilość tranzakcji: " + Integer.toString(ilosc) + System.lineSeparator());
            fileWriter.write("Dzienny przychod PLN = " + Double.toString(kantor.przychodPLN) + System.lineSeparator());
            fileWriter.write("Dzienny przychod USD = " + Double.toString(kantor.przychodUSD) + System.lineSeparator());
            fileWriter.write("Dzienny przychod EUR = " + Double.toString(kantor.przychodEUR) + System.lineSeparator());
            fileWriter.write("Dzienny przychod GBP = " + Double.toString(kantor.przychodGBP) + System.lineSeparator());
            fileWriter.write("Dzienny przychod CHF = " + Double.toString(kantor.przychodCHF) + System.lineSeparator());
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
                System.out.println("Zapis zakonczony powodzeniem!");
            }
        }
    }
}