public class Produkt {
    private String nazwa;
    private double cena;
    private int stanMagazynowy;

    public Produkt(String nazwa,double cena,int stanMagazynowy) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.stanMagazynowy = stanMagazynowy;
    }
    public boolean czyDostepny (int ilosc) {
        return stanMagazynowy >= ilosc;
    }
    public void zdejmijZMagazynu(int ilosc) {
        this.stanMagazynowy -= ilosc;

    }
    public double getCena(){return cena;}
    public String getNazwa(){return nazwa;}
}

