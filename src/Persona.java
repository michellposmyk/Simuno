public class Persona {
    private String imie;
    private String nazwisko;
    private String wlasciciel;
    private int wiek;
    private int wzrost;

    public Persona(String wlasciciel,int wzrost) {
        this.wlasciciel = wlasciciel;
        this.wzrost = wzrost;
    }
    public String imie() {
        return imie;
    }



  public String Tomek() {
      return "jeden dwa trzy";
  }

  public String jestemAktywny(boolean czyZmeczony) {
      return "zmeczony";
  }



}
