/*
Projekt nr 14 - Kantor wymiany walut

Grzegorz Musiał
Paweł Kowieski
Tomasz Mielczarek

Informatyka - Grupa 2
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        String csvFile = "src/aktualneWaluty.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        Tranzakcje tranzakcje = new Tranzakcje();

        try {
            long countOfLines = Files.lines(Paths.get(new File(csvFile).getPath())).count();

            Kantor kantor = new Kantor((int) countOfLines - 1);

            br = new BufferedReader(new FileReader(csvFile));

            boolean pominPierwszaLinie = true;
            int czytanaLinia = 0;
            while ((line = br.readLine()) != null) {
                if (pominPierwszaLinie) {
                    pominPierwszaLinie = false;
                    continue;
                }

                String[] slowo = line.split(cvsSplitBy);

                Waluta waluta = new AktualneWaluty(
                        slowo[0].trim(),
                        slowo[1].trim(),
                        Double.parseDouble(slowo[2].trim()),
                        Double.parseDouble(slowo[3].trim()),
                        Double.parseDouble(slowo[4].trim())
                );
                kantor.dodajWalute(waluta, czytanaLinia);
                czytanaLinia++;
            }
            menuGlowne(kantor, tranzakcje);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void menuGlowne(Kantor kantor, Tranzakcje tranzakcje) {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        Interfejs.menuGlowneKomunikaty();
        int wynik = wczytajLiczbe(0, 6);
        switch (wynik) {
            case 0:
                wyjdz(kantor);
                break;
            case 1:
                kantor.wyswietlWaluty();
                System.out.println("Data i godzina kursów: " + localDate + " " + localTime);
                menuGlowne(kantor, tranzakcje);
            case 2:
                kupWaluty(kantor, tranzakcje);
                menuGlowne(kantor, tranzakcje);
            case 3:
                sprzedajWaluty(kantor, tranzakcje);
                menuGlowne(kantor, tranzakcje);
            case 4:
                tranzakcje.pokazIloscTranzakcji();
                tranzakcje.zestawieniePrzychodow(kantor);
                menuGlowne(kantor, tranzakcje);
            case 5:
                wczytanieStarychWalut();
                menuGlowne(kantor, tranzakcje);
            case 6:
                tranzakcje.zestawienieIlosci(kantor);
                menuGlowne(kantor, tranzakcje);
            default:
                wyjdz(kantor);
                break;
        }
    }

    private static void kupWaluty(Kantor kantor, Tranzakcje tranzakcje) {

        Interfejs.kupWalutyKomunikaty();
        Scanner scan = new Scanner(System.in);
        double iloscKupionejWaluty;
        int wynik = wczytajLiczbe(0, 4);
        switch (wynik) {
            case 0:
                wyjdz(kantor);
                break;
            case 1:
                System.out.println("Ile Dolarów chcesz kupić ?");
                iloscKupionejWaluty = scan.nextInt();
                kantor.kupUSD(iloscKupionejWaluty);
                tranzakcje.iloscTranzakcji();
                menuGlowne(kantor, tranzakcje);
            case 2:
                System.out.println("Ile Euro chcesz kupić ?");
                iloscKupionejWaluty = scan.nextInt();
                kantor.kupEUR(iloscKupionejWaluty);
                tranzakcje.iloscTranzakcji();
                menuGlowne(kantor, tranzakcje);
            case 3:
                System.out.println("Ile Funtów chcesz kupić ?");
                iloscKupionejWaluty = scan.nextInt();
                kantor.kupGBP(iloscKupionejWaluty);
                tranzakcje.iloscTranzakcji();
                menuGlowne(kantor, tranzakcje);
            case 4:
                System.out.println("Ile Franków chcesz kupić ?");
                iloscKupionejWaluty = scan.nextInt();
                kantor.kupCHF(iloscKupionejWaluty);
                tranzakcje.iloscTranzakcji();
                menuGlowne(kantor, tranzakcje);
            default:
                wyjdz(kantor);
                break;
        }
    }

    private static void sprzedajWaluty(Kantor kantor, Tranzakcje tranzakcje) {

        Interfejs.sprzedajWalutyKomunikaty();
        Scanner scan = new Scanner(System.in);
        double iloscSprzedanejWaluty;
        int wynik = wczytajLiczbe(0, 4);
        switch (wynik) {
            case 0:
                wyjdz(kantor);
                break;
            case 1:
                System.out.println("Ile Dolarów chcesz sprzedać ?");
                iloscSprzedanejWaluty = scan.nextInt();
                kantor.sprzedajUSD(iloscSprzedanejWaluty);
                tranzakcje.iloscTranzakcji();
                menuGlowne(kantor, tranzakcje);
            case 2:
                System.out.println("Ile Euro chcesz sprzedać ?");
                iloscSprzedanejWaluty = scan.nextInt();
                kantor.sprzedajEUR(iloscSprzedanejWaluty);
                tranzakcje.iloscTranzakcji();
                menuGlowne(kantor, tranzakcje);
            case 3:
                System.out.println("Ile Funtów chcesz sprzedać ?");
                iloscSprzedanejWaluty = scan.nextInt();
                kantor.sprzedajGBP(iloscSprzedanejWaluty);
                tranzakcje.iloscTranzakcji();
                menuGlowne(kantor, tranzakcje);
            case 4:
                System.out.println("Ile Franków chcesz sprzedać ?");
                iloscSprzedanejWaluty = scan.nextInt();
                kantor.sprzedajCHF(iloscSprzedanejWaluty);
                tranzakcje.iloscTranzakcji();
                menuGlowne(kantor, tranzakcje);
            default:
                wyjdz(kantor);
                break;
        }
    }

    private static int wczytajLiczbe(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        int a = scanner.nextInt();
        if (a >= min && a <= max) {
            return a;
        } else {
            return wczytajLiczbe(min, max);
        }
    }

    private static void wyjdz(Kantor kantor) {
        System.out.println("Zapisuje dane o tranzakcjach do pliku tranzakcje.txt");
        try {
            Tranzakcje.zapiszTranzakcje(kantor);
        } catch (IOException ex) {
            System.out.println("Wystąpił błąd podczas zapisu" + ex.getMessage());
        }
        System.exit(0);
    }

    private static void wczytanieStarychWalut() {
        String csvFile = "src/stareWaluty.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        try {
            long countOfLines = Files.lines(Paths.get(new File(csvFile).getPath())).count();
            Kantor kantor = new Kantor((int) countOfLines - 1);

            br = new BufferedReader(new FileReader(csvFile));

            boolean pominPierwszaLinie = true;
            int czytanaLinia = 0;
            while ((line = br.readLine()) != null) {
                if (pominPierwszaLinie) {
                    pominPierwszaLinie = false;
                    continue;
                }

                String[] slowo = line.split(cvsSplitBy);

                Waluta waluta = new StareWaluty(
                        slowo[0].trim(),
                        slowo[1].trim(),
                        Double.parseDouble(slowo[2].trim()),
                        Double.parseDouble(slowo[3].trim()),
                        Double.parseDouble(slowo[4].trim())
                );
                kantor.dodajWalute(waluta, czytanaLinia);
                czytanaLinia++;
            }
            System.out.println();
            kantor.wyswietlStareWaluty();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}