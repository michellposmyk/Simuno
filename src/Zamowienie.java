import java.util.ArrayList;
import java.util.List;

public class Zamowienie {
    private List<Produkt> listaProduktow = new ArrayList<>();
    private boolean czyOplacone = false;
    private static final double PROG_Z_RABATEM = 500.0;
    public void dodajProdukt(Produkt p,int ilosc) {
        if (p.czyDostepny(ilosc)) {
            for (int i = 0; i < ilosc; i++) {
                listaProduktow.add(p);
            }
            p.zdejmijZMagazynu(ilosc);
            System.out.println("Dodano: " + p.getNazwa());
        } else {
            System.out.println("Brak towaru: "+ p.getNazwa());

        }
    }
    public double obliczSumeKoncowa() {
        double suma = 0;
        for (Produkt p : listaProduktow) {
            suma += p.getCena();

        }
        if (suma > PROG_Z_RABATEM) {
            suma = zastosujRabat(suma, 0.10);

        }
        return suma;
    }

    private double zastosujRabat(double suma, double v) {
        return suma;
    }


    public static String generujNaglowekFaktury (int numer) {
            return "Faktura NR: "+ numer + "|Data : "+ java.time.LocalDate.now();
        }
    }

