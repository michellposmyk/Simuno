import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println("Witaj w moim krolestwie.Twoja godzina to  " + now.format(timeFormatter));

        int hour = now.getHour();
        if (hour < 12) {
            System.out.println("Witaj, czas na 10 brzuszkow");
        } else if (hour < 18) {
            System.out.println("Jestes, teraz 5 brzuszkow");
        } else {
            System.out.println("Niezapomnij o 10 pompkach");
        }
        while (true) {
            System.out.println("---- MENU WYBORU ----");
            System.out.println("1. Dodaj osobe do bazy");
            System.out.println("2. Zajdz osobe");
            System.out.println("3. Usun osobe");
            System.out.print("Twoj wybor: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Blad! Wpisz liczbe 1-3");
                scanner.nextLine();
                continue;
            }

            int wybor = scanner.nextInt();
            scanner.nextLine();

            if (wybor == 1) {
                dodajOsobe(scanner);
            } else if (wybor == 2) {
                szukajOsoby(scanner);
            } else if (wybor == 3) {
                usunOsobe(scanner);
            } else {
                System.out.println("Nieprawidlowy wybor");

            }
        }
    }
    public static void dodajOsobe(Scanner sc) {
        System.out.println("Podaj imie: ");
        String imie = sc.nextLine();
        System.out.println("Podaj nazwisko: ");
        String nazwisko = sc.nextLine();
        System.out.println("Podaj opis");
        String opis = sc.nextLine();

        try (PrintWriter out = new PrintWriter(new FileWriter("baza_osob.txt", true))) {
            out.println(imie + ";" + nazwisko + ";" + opis);
            System.out.println("Osoba zostala dodana pomyslnie");
        } catch (IOException e) {
            System.out.println("Blad zapisu do bazy");
        }
    }
    public static void szukajOsoby(Scanner sc) {
        System.out.print("Podaj imie do znalezienie: ");
        String szukaneImie = sc.nextLine();
        System.out.print("Podaj nazwisko do znalezienia: ");
        String szukaneNazwisko = sc.nextLine();
        boolean znaleziono = false;

        try (BufferedReader br = new BufferedReader(new FileReader("baza_osob.txt"))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                String[] dane = linia.split(";");
                if (dane[0].equalsIgnoreCase(szukaneImie) && dane[1].equalsIgnoreCase(szukaneNazwisko)) {
                    System.out.println("Znaleziono! Opis:" + dane[2]);
                    znaleziono = true;
                    break;
                }
            }
            if (!znaleziono) System.out.println("Nie ma takiej osoby w bazie");

        } catch (FileNotFoundException e) {
            System.out.println("Bland Nie znalziono pliku bazy danych");

        } catch (IOException e ) {
            System.out.println("Bland poczas oczytyu plikow");
        }

    }
    public static void usunOsobe(Scanner sc) {
        System.out.println("Imie osoby do usuniecia: ");
        String uImie = sc.nextLine();
        System.out.println("Nazwisko osoby do usuniecia: ");
        String uNazwisko = sc.nextLine();
        File plikOriginalny = new File("baza_osob.txt");
        File plikTymczasowy = new File("baza_temp.txt");
        boolean usunieto = false;

        try (BufferedReader br = new BufferedReader(new FileReader(plikOriginalny));
             PrintWriter pw = new PrintWriter(new FileWriter(plikTymczasowy))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                String[] dane = linia.split(";");
                if (!(dane[0].equalsIgnoreCase(uImie) && dane[1].equalsIgnoreCase(uNazwisko))) {
                    pw.println(linia);
                } else {
                    usunieto = true;

                }
            }
        } catch (IOException e) {
            System.out.println("Blad pliku");
            return;
        }
        if (plikOriginalny.delete() && plikTymczasowy.renameTo(plikOriginalny)) {
            System.out.println(usunieto ? "Osoba usunieta." : "Nie znaleziono osoby.");


        }
    }


}
