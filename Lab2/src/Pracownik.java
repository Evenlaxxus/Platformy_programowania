public class Pracownik extends Osoba {
    private Stanowisko stanowisko;
    private double pensja;
    public Pracownik(String imie, String nazwisko, int wiek, Stanowisko stanowisko, double pensja) {
        super(imie, nazwisko, wiek);
        this.stanowisko=stanowisko;
        this.pensja=pensja;
    }

    public Stanowisko getStanowisko() {
        return stanowisko;
    }

    public double getPensja() {
        return pensja;
    }

    public String toString(){
        return super.toString() + "Stanowisko: " + this.getStanowisko() + "\nPensja: " + this.getPensja() + "\n";
    }
}

