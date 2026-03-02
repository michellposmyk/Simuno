import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Produkt laptop = new Produkt ("Laptop Lenovo",3500.0,2);
        Produkt myszka = new Produkt("myszka logic",120,5);
        Produkt podkladka = new Produkt("podkladka",50.0,1);

        Zamowienie mojeZamowienie = new Zamowienie();
        System.out.println("---Rozpoczecie zakupow----");
        mojeZamowienie.dodajProdukt(laptop,1);
        mojeZamowienie.dodajProdukt(myszka,2);
        mojeZamowienie.dodajProdukt(podkladka,1);

        double suma = mojeZamowienie.obliczSumeKoncowa();
        System.out.println("--------------");
        System.out.println(Zamowienie.generujNaglowekFaktury(2121));
        System.out.println("Do zaplaty (po rabatach): "+ suma + "zl");

        System.out.println("pozostalo laptopow w magazynie: ");

    }
}
